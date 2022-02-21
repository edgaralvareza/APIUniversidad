package com.ibm.proyectos.universidad.controladores;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;
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
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/restapi")
public class PersonaController
{
    private final static Logger logger = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaDAO personaDAO;

    /**
     * Endpoint para consultar todas las personas
     * @return Retorna una lista de personas
     * @author EEAA - 17-02-2022
     */
    @ApiOperation(value = "Consultar todas las personas")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
            @ApiResponse(code = 404, message = "No hay elementos en la base de datos")
    })
    @GetMapping("/personas/lista")
    public List<Persona> listarTodas()
    {
        List<Persona> personas = (List<Persona>) personaDAO.buscarTodos();
        return personas;
    }


    /**
     * Endpoint para consultar una persona por id
     * @param personaId ParÃ¡metro de bÃºsqueda de la persona
     * @return Retorna un objeto de tipo persona
     * @NotFoundException En caso de que falle buscando la persona
     * @author -EEAA - 17-02-2022
     */


    @GetMapping("/persona/personaId/{personaId}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long personaId)
    {
        Optional<Persona> oPersona = personaDAO.buscarPorId(personaId);

        if(!oPersona.isPresent())
            throw new NotFoundException(String.format("La PERSONA con id: %d no existe", personaId));

        return new ResponseEntity<Persona>(oPersona.get(), HttpStatus.OK);
    }



    /**
     *Endpoint para guardar una nueva persona
     * @param persona Parametro para buscar la persona
     * @param result Parametro que guarda la lista de errores
     * @return Retorna un objeto de tipo persona
     * EEAA - 18-02-2022
     */
    @PostMapping("/persona")
    public ResponseEntity<?> guardar(@Valid @RequestBody Persona persona, BindingResult result)
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

        Persona personaGuardada = personaDAO.guardar(persona);
        return new ResponseEntity<Persona>(personaGuardada, HttpStatus.CREATED);
    }


    /**
     * Endpoint para eliminar persona
     * @param personaId Parametro para buscar la personaa
     * @return Retorna unicamente una lista de errores
     * EEAA - 18-02-2022
     */

    @DeleteMapping("/persona/eliminar/personaId/{personaId}")
    public ResponseEntity<?> eliminar(@PathVariable Long personaId)
    {
        Optional<Persona> oPersona = personaDAO.buscarPorId(personaId);

        if(!oPersona.isPresent())
            throw new NotFoundException(String.format("La persona con id: %d no existe", personaId));

        personaDAO.eliminarPorId(personaId);
        return new ResponseEntity<>("La persona con id: " + personaId + " fue eliminada", HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint para actualizar persona
     * @param personaId Parametro para buscar persona
     * @param persona parametro Body de actualizacion
     * @param result Lista de errores
     * @return Retorna un objeto de tipo persona
     * EEAA - 18-02-2022
     */
    @PutMapping("/persona/actualizar/personaId/{personaId}")
    public ResponseEntity<?> actualizar(@PathVariable Long personaId, @Valid @RequestBody Persona persona, BindingResult result)
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

        Persona personaActualizada = null;

        try
        {
            personaActualizada = personaDAO.actualizar(personaId, persona);
        }
        catch (Exception e)
        {
            logger.info(e.getMessage());
            throw e;
        }

        return new ResponseEntity<Persona>(personaActualizada, HttpStatus.OK);
    }


    @GetMapping("/persona/personaDni/{personaDni}")
    public ResponseEntity<?> buscarPorDni(@PathVariable String personaDni)
    {
        Optional<Persona> oPersona = personaDAO.buscarPorDni(personaDni);

        if(!oPersona.isPresent())
            throw new NotFoundException(String.format("La PERSONA con DNI: %d no existe", personaDni));

        return new ResponseEntity<Persona>(oPersona.get(), HttpStatus.OK);
    }

    @GetMapping("/persona/personaApellido/{personaApellido}")
    public ResponseEntity<?> buscarPorApellido(@PathVariable String personaApellido)
    {
        Optional<Persona> oPersona = personaDAO.buscarPersonaPorApellido(personaApellido);

        if(oPersona.isEmpty())
            throw new NotFoundException(String.format("La PERSONA con apellido: %d no existe", personaApellido));

        return new ResponseEntity<Persona>(oPersona.get(),HttpStatus.OK);
    }


}
