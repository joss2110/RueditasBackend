package pe.edu.cibertec.RueditasBackend.service;

import pe.edu.cibertec.RueditasBackend.dto.RequestConsultaModel;
import pe.edu.cibertec.RueditasBackend.dto.ResponseConsultaModel;

import java.io.IOException;

public interface ConsultaService {
    ResponseConsultaModel consultarVehiculo(RequestConsultaModel requestConsultaModel) throws IOException;
}
