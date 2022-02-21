package com.ibm.proyectos.universidad.controladores;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Carrera;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.ProfesorDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class ProfesorController
{
    private final static Logger logger = LoggerFactory.getLogger(ProfesorController.class);


    @Autowired
    @Qualifier("profesorDAOImpl")
    private ProfesorDAO profesorDAO;


    /**
     * Endpoint para guardar un profesor
     * @param profesor Parametro body para guardar datos
     * @return Retorna un objeto de tipo Persona
     */
    @PostMapping("/crear/profesor")
    public ResponseEntity<?> crearProfesor(@RequestBody Persona profesor)
    {
        Persona profesorGuardado = profesorDAO.guardar(profesor);
        return new ResponseEntity<Persona>(profesorGuardado, HttpStatus.CREATED);
    }

    /**
     * Endpoint para obtener todos los profesores
     * @return retorna lista de objetos de tipo persona
     * EEAA - 18-02-2022
     */
    @GetMapping("/profesores/lista")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> profesores = (List<Persona>) profesorDAO.buscarTodos();

        if(profesores.isEmpty())
            throw new NotFoundException("No existen profesores");

        return new ResponseEntity<List<Persona>>(profesores, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener profesor por su ID
     * @param profesorId Parametro para buscar al profesor
     * @return Retorna un objeto de tipo persona
     * EEAA - 18-02-2022
     */
    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<?> obtenerprofesorPorId(@PathVariable Long profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("Profesor con id %d no existe", profesorId));

        return new ResponseEntity<Persona>(oProfesor.get(), HttpStatus.OK);
    }

    /**
     * Endpoint para eliminar un profesor por su ID
     * @param profesorId Parametro para buscar al profesor
     * @return Retorna un string que confirma la eliminacion
     * EEAA - 18-02-2022
     */
    @DeleteMapping("/profesor/eliminar/profesorId/{profesorId}")
    public ResponseEntity<?> eliminarProfesor(@PathVariable Long profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorId(profesorId);

        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("El profesor con ID %d no existe", profesorId));

        profesorDAO.eliminarPorId(oProfesor.get().getId());
        return new ResponseEntity<String>("Profesor ID: " + profesorId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint para actualizar un profesor usando su ID
     * @param profesorId Parametro para buscar al alumno
     * @param profesor Body que indica los cambios al objeto
     * @return Retorna un objeto de tipo persona
     */
    @PutMapping("/profesor/actualizar/profesorId/{profesorId}")
    public ResponseEntity<?> actualizarProfesor(@PathVariable Long profesorId, @RequestBody Persona profesor)
    {
        Persona profesorActualizado = ((ProfesorDAO)profesorDAO).actualizar(profesorId, profesor);
        return new ResponseEntity<Persona>(profesorActualizado, HttpStatus.OK);
    }

    @PutMapping("/profesor/asociar-carrera")
    public ResponseEntity<?> asignarCarreraProfesor(@RequestParam Long carreraId, @RequestParam(name = "profesor_id") Long profesorId)
    {
        Persona profesor = ((ProfesorDAO)profesorDAO).asociarCarreraProfesores(carreraId, profesorId);
        return new ResponseEntity<Persona>(profesor, HttpStatus.OK);



    }




}
