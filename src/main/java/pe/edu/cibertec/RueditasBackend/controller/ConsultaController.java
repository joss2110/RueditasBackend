package pe.edu.cibertec.RueditasBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.RueditasBackend.dto.RequestConsultaModel;
import pe.edu.cibertec.RueditasBackend.dto.ResponseConsultaModel;
import pe.edu.cibertec.RueditasBackend.service.ConsultaService;

import java.io.IOException;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService consultaService;

    @PostMapping("/vehiculo")
    public ResponseConsultaModel consultarVehiculo(@RequestBody RequestConsultaModel requestConsultaModel) {

        try {
            ResponseConsultaModel datosVehiculo = consultaService.consultarVehiculo(requestConsultaModel);
            if (datosVehiculo == null) {
                return new ResponseConsultaModel("01", "No se encontró un vehículo para la placa ingresada", "", "", "", "", "");
            }
            return datosVehiculo;
        } catch (IOException e) {
            return new ResponseConsultaModel("99", "Error: Ocurrió un problema", "", "", "", "", "");
        }

    }

}
