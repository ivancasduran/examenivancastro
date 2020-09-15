Feature: Test ingresando nombre de usuario y contrasena validos
Scenario: Verificacion de inicio de sesion ingresando credenciales
Given Abrir Chrome Login Correcto
When Ingresar username "ivan" y userpass "9213" validos
Then Inicio sesion satisfactiriamente