package com.ibm.proyectos.universidad.controladores;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.EmpleadoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restapi")
public class EmpleadoController
{
    private final static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoDAO empleadoDAO;

    /**
     * Endpoint para guardar un empleado
     * @param empleado Parametro body para guardar datos
     * @return Retorna un objeto de tipo Persona
     * EEAA - 18-02-2022
     */
    @PostMapping("/empleado")
    public ResponseEntity<?> crearEmpleado(@RequestBody Persona empleado)
    {
        Persona empleadoGuardado = empleadoDAO.guardar(empleado);
        return new ResponseEntity<Persona>(empleadoGuardado, HttpStatus.CREATED);
    }


    /**
     * Endpoint para obtener todos los empleados
     * @return retorna lista de objetos de tipo persona
     * EEAA - 18-02-2022
     */
    @GetMapping("/empleados/lista")
    public ResponseEntity<?> obtenerTodos()
    {
        List<Persona> empleados = (List<Persona>) empleadoDAO.buscarTodos();

        if(empleados.isEmpty())
            throw new NotFoundException("No existen empleados");

        return new ResponseEntity<List<Persona>>(empleados, HttpStatus.OK);
    }

    /**
     * Endpoint para obtener empleadoo por su ID
     * @param empleadoId Parametro para buscar al alumno
     * @return Retorna un objeto de tipo persona
     * EEAA - 18-02-2022
     */
    @GetMapping("/empleado/{empleadoId}")
    public ResponseEntity<?> obtenerEmpleadoPorId(@PathVariable Long empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException(String.format("Empleado con id %d no existe", empleadoId));

        return new ResponseEntity<Persona>(oEmpleado.get(), HttpStatus.OK);
    }

    /**
     * Endpoint para eliminar un empleado por su ID
     * @param empleadoId Parametro para buscar al alumno
     * @return Retorna un string que confirma la eliminacion
     */
    @DeleteMapping("/empleado/eliminar/empleadoId/{empleadoId}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Long empleadoId)
    {
        Optional<Persona> oEmpleado = empleadoDAO.buscarPorId(empleadoId);

        if(!oEmpleado.isPresent())
            throw new NotFoundException(String.format("El empleado con ID %d no existe", empleadoId));

        empleadoDAO.eliminarPorId(oEmpleado.get().getId());
        return new ResponseEntity<String>("Empleado ID: " + empleadoId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
    }


    /**
     * Endpoint para actualizar un empleado usando su ID
     * @param empleadoId Parametro para buscar al empleado
     * @param empleado Body que indica los cambios al objeto
     * @return Retorna un objeto de tipo persona
     */
    @PutMapping("/empleado/actualizar/empleadoId/{empleadoId}")
    public ResponseEntity<?> actualizarEmpleado(@PathVariable Long empleadoId, @RequestBody Persona empleado)
    {
        Persona empleadoActualizado = ((EmpleadoDAO)empleadoDAO).actualizar(empleadoId, empleado);
        return new ResponseEntity<Persona>(empleadoActualizado, HttpStatus.OK);
    }



}
