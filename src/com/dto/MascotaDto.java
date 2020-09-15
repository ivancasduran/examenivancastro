package com.dto;

public class MascotaDto {

	private Integer idMascota;
	private Integer rutDueño;
	private String tipoMascota;
	private Integer edad;
	private String nombreMascota;
	public MascotaDto() {
	}
	public Integer getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}
	public Integer getRutDueño() {
		return rutDueño;
	}
	public void setRutDueño(Integer rutDueño) {
		this.rutDueño = rutDueño;
	}
	public String getTipoMascota() {
		return tipoMascota;
	}
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
}
