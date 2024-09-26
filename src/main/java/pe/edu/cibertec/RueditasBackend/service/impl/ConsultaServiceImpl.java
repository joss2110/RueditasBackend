package pe.edu.cibertec.RueditasBackend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.RueditasBackend.dto.RequestConsultaModel;
import pe.edu.cibertec.RueditasBackend.dto.ResponseConsultaModel;
import pe.edu.cibertec.RueditasBackend.service.ConsultaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    ResourceLoader resourceLoader;


    @Override
    public ResponseConsultaModel consultarVehiculo(RequestConsultaModel requestConsultaModel) throws IOException {
        ResponseConsultaModel datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (requestConsultaModel.placa().equals(datos[1]) ) {
                    datosVehiculo = new ResponseConsultaModel("00","",datos[2],datos[3],datos[4],datos[5],datos[6]);
                    break;
                }
            }
        } catch (IOException e) {
            datosVehiculo = null;
            throw new IOException(e);
        }
        return datosVehiculo;
    }
}
