package org.dh.c2023I.clinica.controller;

import org.apache.log4j.Logger;
import org.dh.c2023I.clinica.model.Paciente;
import org.dh.c2023I.clinica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController implements IController<Paciente>{

    Logger logger = Logger.getLogger(PacienteController.class);

    PacienteService service = new PacienteService();

    @Override
    @GetMapping("todos")
    public List<Paciente> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping("crear")
    public Paciente crear(@RequestBody Paciente p){
        return service.crear(p);
    }

    @PutMapping("modificar")
    public Paciente modificar(@RequestBody Paciente p){
        return service.modificar(p);
    }

    @GetMapping("buscarPorId/{id}") //localhost:8080/paciente/buscarPorId/
    public Paciente buscarPorIdPathVariable(@PathVariable Integer id){

           return service.buscarPorID(id);

    }

    @GetMapping("buscarPorId")//localhost:8080/paciente/buscarPorId?id=2
    public Paciente buscarPorIdRequestParam(@RequestParam Integer id){
        return null;
    }

    @DeleteMapping("eliminarPaciente/{id}")
    public Paciente eliminarPorID(@PathVariable Integer id){

        return service.eliminarPorID(id);

    }
}
