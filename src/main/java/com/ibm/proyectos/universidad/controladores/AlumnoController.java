package com.ibm.proyectos.universidad.controladores;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.proyectos.universidad.excepciones.NotFoundException;
import com.ibm.proyectos.universidad.modelo.entidades.Persona;
import com.ibm.proyectos.universidad.servicios.AlumnoDAO;
import com.ibm.proyectos.universidad.servicios.PersonaDAO;

@RestController
@RequestMapping("/restapi")
public class AlumnoController {
	private final static Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	@Qualifier("alumnoDAOImpl")
	private PersonaDAO alumnoDao;

	/**
	 * Endpoint para guardar un alumno
	 * @param alumno Parametro body para guardar datos
	 * @return Retorna un objeto de tipo Persona
	 */
	@PostMapping("/alumno")
	public ResponseEntity<?> crearAlumno(@RequestBody Persona alumno)
	{	
		Persona alumnoGuardado = alumnoDao.guardar(alumno);
		return new ResponseEntity<Persona>(alumnoGuardado, HttpStatus.CREATED);
	}

	/**
	 * Endpoint para obtener todos los alumnos
	 * @return retorna lista de objetos de tipo persona
	 * EEAA - 18-02-2022
	 */
	@GetMapping("/alumnos/lista")
	public ResponseEntity<?> obtenerTodos()
	{
		List<Persona> alumnos = (List<Persona>) alumnoDao.buscarTodos();
		
		if(alumnos.isEmpty())
			throw new NotFoundException("No existen alumnos");
		
		return new ResponseEntity<List<Persona>>(alumnos, HttpStatus.OK);
	}


	/**
	 * Endpoint para obtener alumno por su ID
	 * @param alumnoId Parametro para buscar al alumno
	 * @return Retorna un objeto de tipo persona
	 * EEAA - 18-02-2022
	 */
	@GetMapping("/alumno/{alumnoId}")
    public ResponseEntity<?> obtenerAlumnoPorId(@PathVariable Long alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
        
        if(!oAlumno.isPresent()) 
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        
        return new ResponseEntity<Persona>(oAlumno.get(), HttpStatus.OK);
    }

	/**
	 * Endpoint para eliminar un alumno por su ID
	 * @param alumnoId Parametro para buscar al alumno
	 * @return Retorna un string que confirma la eliminacion
	 */
	@DeleteMapping("/alumno/eliminar/alumnoId/{alumnoId}")
	public ResponseEntity<?> eliminarAlumno(@PathVariable Long alumnoId)
	{
		Optional<Persona> oAlumno = alumnoDao.buscarPorId(alumnoId);
		
		if(!oAlumno.isPresent())
			throw new NotFoundException(String.format("El alumno con ID %d no existe", alumnoId));
		
		alumnoDao.eliminarPorId(oAlumno.get().getId()); 
		return new ResponseEntity<String>("Alumno ID: " + alumnoId + " se elimino satisfactoriamente",  HttpStatus.NO_CONTENT);
	}

	/**
	 * Endpoint para actualizar un alumno usando su ID
	 * @param alumnoId Parametro para buscar al alumno
	 * @param alumno Body que indica los cambios al objeto
	 * @return Retorna un objeto de tipo persona
	 */
	@PutMapping("/alumno/actualizar/alumnoId/{alumnoId}")
	public ResponseEntity<?> actualizarAlumno(@PathVariable Long alumnoId, @RequestBody Persona alumno)
	{
		Persona alumnoActualizado = ((AlumnoDAO)alumnoDao).actualizar(alumnoId, alumno);
		return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
	}

	/**
	 * Endpoint para asocuar un alumno con carrera
	 * @param carreraId Parametro para ubicar la carrera
	 * @param alumnoId Parametro para ubicar al alumno
	 * @return Retorna un objeto de tipo persona
	 */
	
	@PutMapping("/alumno/asociar-carrera")
	public ResponseEntity<?> asignarCarreraAlumno(@RequestParam Long carreraId, @RequestParam(name = "alumno_id") Long alumnoId)
	{
		Persona alumno = ((AlumnoDAO)alumnoDao).asociarCarreraAlumno(carreraId, alumnoId); 
		return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
	
	}
}
