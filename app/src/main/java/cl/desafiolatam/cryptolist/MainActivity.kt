package cl.desafiolatam.cryptolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.desafiolatam.cryptolist.databinding.ActivityMainBinding

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
    [X] dependencias
    [X] Entities
    [X] Dao
    [X] cliente de base de datos
    [X] subclase de application -> agregar al manifest
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
    [X] Crear Fragmento y layout
    [ ] Utilizar ViewModel para pedir información de detalle
[ ] Nombre de usuario utilizando SharedPreferences
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}