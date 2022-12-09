package com.example.resultadodeaprendizajefred.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private val _nombreCliente= mutableStateOf("")
    val nombreCliente : State<String> = _nombreCliente

    private val _nombreVehiculo= mutableStateOf("")
    val nombreVehiculo : State<String> = _nombreVehiculo

    private val _precioVehiculo= mutableStateOf(0.0)
    val precioVehiculo : State<Double> = _precioVehiculo

    private val _porcentajeEnganche= mutableStateOf(0.0)
    val porcentajeEnganche : State<Double> = _porcentajeEnganche

    private val _anioFinanciamiento= mutableStateOf(0)
    val anioFinanciamiento : State<Int> = _anioFinanciamiento

    private val _porcentajeFinanciamiento= mutableStateOf(0.0)
    val porcentajeFinanciamiento : State<Double> = _porcentajeFinanciamiento


    fun asignarNombre(nombre:String){

        _nombreCliente.value = nombre
    }

    fun asignarMarca(marca:String,precio:Double){
        _nombreVehiculo.value = marca
        _precioVehiculo.value = precio
    }

    fun asignarEnganche(porcentajeEnganche:Double){
        _porcentajeEnganche.value = porcentajeEnganche
    }

    fun asignarFinanciamiento(anio:Int,porcentjeFinanciamiento:Double){
        _anioFinanciamiento.value = anio
        _porcentajeFinanciamiento.value = porcentjeFinanciamiento
    }


    fun generarFinanciamiento():String{
        var enganche = _precioVehiculo.value * (_porcentajeEnganche.value/100)
        var montoFinanciar = _precioVehiculo.value - enganche
        var interesPorAnio = montoFinanciar * (_porcentajeFinanciamiento.value/100)
        var interes = interesPorAnio * _anioFinanciamiento.value
        var montoFinanciarInteres = montoFinanciar + interes
        var montoPago = montoFinanciarInteres / (_anioFinanciamiento.value * 12)
        var totalCost=  enganche + montoFinanciarInteres

        return  "Cliente: ${_nombreCliente.value}\n" +
                "Vehiculo: ${_nombreVehiculo.value} \$ ${_precioVehiculo.value}\n" +
                "Enganche: (${_porcentajeEnganche.value}%) de ${enganche}\n" +
                "Monto a financiar: $${montoFinanciar}\n" +
                "Financiamiento: a ${_anioFinanciamiento.value} años, tasa del ${_porcentajeFinanciamiento.value}%\n" +
                "Monto de Intereses: por ${_anioFinanciamiento.value} años = $${interes}\n" +
                "Monto a financiar + interes: = $${montoFinanciar} + $${interes} = $${montoFinanciarInteres}\n" +
                "Pagos mensuales por: $${montoPago}\n" +
                "Costo total: (Enganche+Financiamiento), $${enganche} + $${montoFinanciarInteres}= $${totalCost}"


    }


}