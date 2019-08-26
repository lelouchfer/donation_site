# donation_site
Prueba, sitio de donación

Diagrama entidad relación
![stack Overflow](https://i.ibb.co/5h9MzZ6/online-donation-site-localhost.png)


Dentro del proyecto se encuentra la base de datos, para se cuentan con dos usuarios, con rol administrador y usuario, cada uno de ellos tiene restringido los controladores  que puede visitar, al mismo tiempo se encuentra con sus contraseñas encriptadas, uso de thymleaf y layoutsm.

Importante: uso de lombok, ir a: https://projectlombok.org/order-license-info,
Descargar, seguir las instrucciones para añadir en el ide de preferencia.


Para el uso del servicio "servicexxx/", se tomo la ruta "servicexxx/all", para mostrar toda la información de las donaciones. Siendo el RequestMapping padre ("servicexxx/").

Uso de layouts en thymeleaf.

Las credenciales para el administrador son:
correo: admin@gmail.com
contraseña: admin


Las credenciales para el usuario son:
correo: user@gmail.com
contraseña: user

Los usuarios invitados pueden registrarse, teniendo permisos de usuarios y pudiendo donar.


Debo ser sincero y aclarar que hay partes no están correctamente validades.

