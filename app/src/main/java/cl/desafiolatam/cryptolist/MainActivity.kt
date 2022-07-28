package cl.desafiolatam.cryptolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[X] Creación del proyecto e inicialización de control de versiones
[X] Consumo de API
    [X] dependencias
    [X] POJOs
    [X] Interfaz de operaciones
    [X] cliente de retrofit
    [X] permiso de internet
[X] Repositorio
[ ] ROOM
    [ ] dependencias
    [ ] Entities
    [ ] Dao
    [ ] cliente de base de datos
    [ ] subclase de application -> agregar al manifest
    [ ] Converters
    [ ] Test unitario a conversor de modelo a DB
[X] ViewBinding
    [X] Habilitar
    [X] actualizar fragmento de listado
    [ ] actualizar fragmento de detalle
[ ] corutinas (dependencias)
[X] ViewModel (by viewModels()) -> Implementa el patrón factory
[ ] Actualizar MainActivity y su layout
[ ] Fragmento de listado
    [X] Crear Fragmento
    [X] Layout de item list
    [X] Adapter + ViewHolder + ReciclerView
    [X] dependencia imágenes
    [ ] onClickListener al elemento del listado
    [ ] Abrir fragmento de detalle
[ ] Fragmento de detalle
    [ ] Crear Fragmento y layout
    [ ] Utilizar ViewModel para pedir información de detalle
[ ] Nombre de usuario utilizando SharedPreferences
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}