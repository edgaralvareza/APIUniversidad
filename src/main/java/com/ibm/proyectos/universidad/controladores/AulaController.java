package com.ibm.proyectos.universidad.controladores;


import com.ibm.proyectos.universidad.enumeradores.TipoPizarron;
import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Aula;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.servicios.AulaDAO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restapi")
public class AulaController
{
    private final static Logger logger = LoggerFactory.getLogger(AulaController.class);

    @Autowired
    private AulaDAO aulaDAO;


    /**
     * Endpoint para consultar todas las aulas
     * @return Retorna una lista de aulas.
     * @author EEAA - 17-02-2022
     */
    @ApiOperation(value = "Consultar todas las aulas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos en la base de datos")
    })
    @GetMapping("/aulas/lista")
    public List<Aula> listarTodas()
    {
        List<Aula> aulas = (List<Aula>) aulaDAO.buscarTodos();
        return aulas;
    }



    /**
     *Endpoint para guardar una nueva aula
     * @param aula Parametro para buscar la aula
     * @param result Parametro que guarda la lista de errores
     * @return Retorna un objeto de tipo aula
     * EEAA - 18-02-2022
     */
    @PostMapping("/aula")
    public ResponseEntity<?> guardar(@Valid @RequestBody Aula aula, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Aula aulaGuardada = aulaDAO.guardar(aula);
        return new ResponseEntity<Aula>(aulaGuardada, HttpStatus.CREATED);
    }


    /**
     * Endpoint para eliminar aula
     * @param aulaId Parametro para buscar el aula
     * @return Retorna unicamente una lista de errores
     * EEAA - 18-02-2022
     */

    @DeleteMapping("/aula/eliminar/aulaId/{aulaId}")
    public ResponseEntity<?> eliminar(@PathVariable Long aulaId)
    {
        Optional<Aula> oAula = aulaDAO.buscarPorId(aulaId);

        if(!oAula.isPresent())
            throw new NotFoundException(String.format("El Aula con id: %d no existe", aulaId));

        aulaDAO.eliminarPorId(aulaId);
        return new ResponseEntity<>("El aula con id: " + aulaId + " fue eliminada", HttpStatus.NO_CONTENT);
    }


    /**
     * Endpoint para actualizar aula
     * @param aulaId Parametro para buscar aula
     * @param aula parametro Body de actualizacion
     * @param result Lista de errores
     * @return Retorna un objeto de tipo aula
     * EEAA - 18-02-2022
     */
    @PutMapping("/aula/actualizar/aulaId/{aulaId}")
    public ResponseEntity<?> actualizar(@PathVariable Long aulaId, @Valid @RequestBody Aula aula, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Aula aulaActualizada = null;

        try
        {
            aulaActualizada = aulaDAO.actualizar(aulaId, aula);
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
            throw e;
        }

        return new ResponseEntity<Aula>(aulaActualizada, HttpStatus.OK);
    }


    /**
     * Endpoint para consultar un Aula por Tipo Pizarron
     * @param aulaPizarron ParÃ¡metro de bÃºsqueda de la Aula
     * @return Retorna un objeto de tipo aula
     * @NotFoundException En caso de que falle buscando el aula
     * @author -EEAA - 19-02-2022
     */
    @GetMapping("/aula/aulaPizarron/{aulaPizarron}")
    public ResponseEntity<?> buscarCarreraPorNombre(@PathVariable TipoPizarron aulaPizarron)
    {
        Iterable<Aula> oAula = aulaDAO.findAulaByTipoPizarronContains(aulaPizarron);

        if(oAula.toString().isEmpty())
            throw new NotFoundException(String.format("El aula con pizarron: %d no existe", aulaPizarron));

        return new ResponseEntity<Aula>((Aula) oAula.iterator(),HttpStatus.OK);
    }

    /**
     * Endpoint para consultar un Aula por numero de Aula
     * @param aulaNro ParÃ¡metro de bÃºsqueda de la Aula
     * @return Retorna un objeto de tipo aula
     * @NotFoundException En caso de que falle buscando el aula
     * @author -EEAA - 19-02-2022
     */
    @GetMapping("/aula/aulaNro/{aulaNro}")
    public ResponseEntity<?> buscarCarreraPorNumeroAula(@PathVariable Integer aulaNro)
    {
        Iterable<Aula> oAula = aulaDAO.findAulaBynumeroAulaContains(aulaNro);

        if(oAula.toString().isEmpty())
            throw new NotFoundException(String.format("El aula con Numero de aula: %d no existe", aulaNro));

        return new ResponseEntity<Aula>((Aula) oAula.iterator(),HttpStatus.OK);
    }







}
