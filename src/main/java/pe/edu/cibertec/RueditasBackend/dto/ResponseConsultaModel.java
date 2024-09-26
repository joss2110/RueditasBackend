package pe.edu.cibertec.RueditasBackend.dto;

public record ResponseConsultaModel(String codigo, String mensaje, String marca,
                                    String modelo, String nroAsientos, String precio,
                                    String color) {
}
