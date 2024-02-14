Esto es un proyecto de la segunda evaluación de la asignatura de Multimedia, una aplicación de Android de tema libre
que permite a los usuarios consumir una API y que pueden realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
en publicaciones. Utilizando Retrofit para interactuar con una API web que gestiona las publicaciones de los usuarios.

Se ha utilizado una API propia que además es otro proyecto de la asignatura de Acceso, tambien se utiliza varios
elementos que además eran requisitos mínimos para la nota, como listas, botones, activities, fragments y toasts.

Estructura del Proyecto:

    API:
        ApiCRUD: Interfaz que define los métodos para operaciones CRUD utilizando Retrofit.
        Constants: Clase que contiene la URL base de la API y la identificación de usuario.

    DTO (Data Transfer Object):
        PostDTO: Objeto que representa la información de una publicación. Se utiliza para transferir datos entre la aplicación y la API.

    Modelo:
        Post: Clase que probablemente represente el modelo de datos de una publicación en el lado del servidor.

    Adaptadores:
        PostsAdapter: Adaptador para mostrar la lista de publicaciones en una interfaz de usuario.

    Actividades:
        LoginActivity: Actividad para manejar el inicio de sesión de los usuarios.
        NavigationActivity: Actividad principal que gestiona la navegación entre fragmentos mediante BottomNavigationView.

    Fragmentos:
        HomeFragment: Muestra la lista de publicaciones.
        CreateFragment: Permite a los usuarios crear nuevas publicaciones.
        EditFragment: Permite a los usuarios editar publicaciones existentes.
        DeleteFragment: Permite a los usuarios eliminar publicaciones.
        ExitFragment: No se proporcionó información detallada sobre su funcionalidad.


--------------------------------------------------

Primero se crean unas cuantas carpetas donde se meterán las clases e interfaces necesarias para consumir la API.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/a1d811da-c3d9-4c84-a766-6009d041ff39)

--------------------------------------------------

La carpeta Model contendrá todas las entidades de los objetos que se necesitarán para poder hacer peticiones a la
API y a su vez poder recibir respuestas de objetos.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/8836783c-0cfd-47b5-8a54-0e044225a5e1)

Todas las entidades excepto la de Role contienen constructores vacios como llenos y getters y setters.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/c7cdf08e-1208-4662-84b7-9fb5a2b385cd)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/4152f1d0-12d2-4015-9126-26c9ff6d2a1e)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/5867982a-a512-40d3-b500-420c973ca797)

--------------------------------------------------

La carpeta de DTO contiene las entidades pero con la información que no se quiere mostrar al cliente, por lo
que son parecidas pero quitando a información privada, en está aplicación solo se hacen operaciones CRUD sobre post.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/e7d14154-51fc-4b02-8d97-71199cf50c3c)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/8457661c-4106-407a-838b-8f6b60a48d31)

--------------------------------------------------

La carpeta de Adapters sirve para convertir la respuesta del servidor en algo específico según la necesidad. La clase
se extiende de BaseAdapter los cuales se override unos métodos en los que se podrán sacar toda esa información en una
listview donde se mostrará todo el contenido.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/12532467-e798-47f6-b0e2-e31798d05543)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/517f4303-71d7-4185-ad8c-786e87a00bc0)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/6ba26b73-bd9d-4831-8ee0-fef4bce71937)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/1555ccf1-3134-4f87-b812-895cb2739922)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/bb034c5e-1ec7-43a2-8516-1b1926e568ec)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/9e6aa620-d68f-4b37-9803-ee4057b111b7)

--------------------------------------------------

En la carpeta de Interface contendrá todos los endpoints de la API de la que necesitará la app para poder consumir
la API. Se necesitarán por lo tanto la de login, PostByUserId, createPost, updatePost y deletePost, cada una con
sus argumentos necesarios.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/b20d6094-7a42-41e1-9f1c-dc85b89b0287)

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/2d6bed70-32bd-4091-a1ef-194148236ea4)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/492ef713-dc8b-4a01-84d8-3617e46a0e75)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/6268c4f8-6f65-4c36-846a-e8bde62a28d8)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/7946add5-b170-414f-90dc-032f2702db64)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/32a879c2-eeec-49e0-be09-f45d012eb96f)

--------------------------------------------------

La carpeta de Security contendrá todos los objetos que se necesitarán para poder enviar y recibir una respuesta en
el método de login.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/a3cdb30e-6f63-4582-930e-9abbd1d4ac1d)

Todas contienen constructores vacios como llenos y getters y setters.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/874a15f8-4b10-4a01-a668-c4ea87096f47)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/9f28be9e-4ce5-44db-90f5-8ae895d13f5c)

--------------------------------------------------

Y finalmente la carpeta de Constants contendrá todos los valores que estaremos utilizando constantemente, como la 
url de la API y el id del usuario por solo haber uno en la Base de Datos.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/f6d66bf4-97ba-4feb-a2e1-f865290e1875)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/2f0eaf61-22fe-40e8-a339-da29ccb93c2f)

--------------------------------------------------

Primero se empieza creando un proyecto vacio de View Empty Activity, se crean dos activities llamados LoginActivity y NavigationActivity
los cuales manegarán la lógica según su nombre, se diseña el xml.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/c7095a34-43f0-46e0-b67c-85284210e218)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/7019d884-c9fa-43a4-9aa4-d80d6aea630c)

Se empiza con el código del LoginActivty. Utilizaremos la librería de Retrofit, un cliente de servidores REST para Android
y Java. Permite hacer peticiones al servidor tipo: GET, POST, PUT, PATCH, DELETE y HEAD, y gestionar diferentes tipos de parámetros,
paseando automáticamente la respuesta a un tipo de datos.

Cade vez que haya que hacer una petición al servidor se utilizará el mismo código, en este caso, la actividad de Login solo necesita
los parámetros de username y password, que son los argumentos que necesita la endpoint de la API.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/d668d21b-6c8b-4f82-8e6e-2031b41dea4d)

Hay que llamar los elementos de la interfaz en el método de onCreate, buscandolos por su id.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/23086811-fa34-4ba2-936c-58f3be1636dd)

Ahora solo queda hacer el método del boton del login para que envíe la petición al servidor. Se llama al método de la interfaz
de ApiCRUD que es donde está el endpoint para poder hacer el login a la API, se le añaden los argumentos necesarios para enviar
al servidor que son el username y el password.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/92fafbdb-4bd4-444d-b156-7b1337f5f29e)

Habrá que hacer un override loc cuales aparecerán los métodos de onResponse y onFailure, que manejarán la respuesta del servidor
dependiendo de si es positiva o negativa, además también se ha puesto un mesaje de notificación al usuario según lo que suceda:

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/de7e605b-5359-4f00-89a5-a1dc388c98b0)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/e7f0c556-9f26-4058-a2b0-456b61c9db8a)

--------------------------------------------------

Segundo, se empieza con el codigo del NavigationActivity que manejará la navegación entre los diferentes fragments que harán una
operación CRUD en específico. El NavigationActivity contendrá un bottom navigation bar con los fragments donde se pulsarán para
cambiar de uno a otro, y además un fragment container que es donde se mostrará el contenido del fragment elegido.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/63a06ce6-6d48-49b6-a119-348aecb86818)

Primero hay que crear un archivo de referencia de tipo menu donde se creará el diseño y cuantos items contendrá.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/d3828751-e422-4ab8-b4e1-2a05194d06b2)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/a8ca9ecb-a80d-42ae-82c7-9b09d02b0706)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/fd2f2f73-0683-4e78-8228-86be78102255)

Segundo, se crea la navegacion entre fragments con un archivo de tipo navigation.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/af664092-679b-4367-aa7a-c3c51140ab04)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/137bb15c-fa9f-4aa1-91bd-3c635c11ffd4)

Se relaciona cada elemento del activity en el codigo del NavigaitonActivity con el metodo a realizar.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/cb21b20a-519e-4cce-a9d4-6bc50ee74f38)

Se utiliza el NavHostFragment como host para navegar entre fragments.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/e9c6eb5f-a375-483c-9a74-151127d9e05d)

Y finalmente se configura cada item del NavHostFragment con que el fragment deseado, el fragment de exit simplemente
se hace un nuevo intent para cambiar de activity y volver al activity del login.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/7983daea-b077-4e3b-a177-1eccf28a447b)

--------------------------------------------------

Tercero, se empiza con el HomeFragment primero que hará una petición de GET a la API para mostrar todas las publicaciones de un
usuario en concreto.

Primero se crea un archivo xml con el layout de la listview.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/b589dc99-a92b-437e-81af-81c16204ad44)

Se crea el diseño según se vea conveniente.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/c0ee1e71-67be-4eb9-8f51-274b0e4b4a08)

Ahora con el código, para poder mostrar los elementos en una lista se necesitarán los siguientes elementos.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/6c93cf91-d8f0-479e-8d90-b0fa4b242890)

Hay que relacionar la lista con el id elegido.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/47122b49-e212-4928-858f-c9fd330b2d47)

Se vuelve a utilizar el mimsmo codigo de la librería del Retrofit pero cambiando los arguemtos necesarios.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/27f66ddd-082c-40ad-a238-f9a03888bbf5)

Tambien se modifica el método de onFailure para que maneje las excepciones.

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/d83da31b-26f2-4ac7-95d8-c481b98790d7)

--------------------------------------------------

Los siguientes fragments de crear, editar y borrar siguen un modelo muy similar, cambiando según lo os argumentos 
que necesite el endpoint.

El de crear:

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/ac865137-c9e8-489f-9cd7-680a26da05aa)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/2f6e2ad0-7842-4db9-9bcc-d6f2ac46437d)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/54ea0e7b-7e0e-4916-8b8c-ef4390dd7166)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/3eea1db5-fefa-4a39-b3a3-bc233a95dd0e)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/6229ad2c-7710-46ff-aae2-106c83817812)

El de editar:

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/c2c6ed6a-98aa-4ca1-9603-38bd11a18f6d)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/92179558-2966-40b9-ad89-5bbb77b51f48)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/e71638e6-30fd-47ac-b449-288d62da6113)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/dc170a02-123a-4fee-9c90-f76b488d01aa)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/3530a59e-6358-4316-bb97-32610ce408f1)

El de borrar:

![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/fdbc3ce8-a3a4-4646-8ba3-aeacbee9385d)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/d1fda446-7029-4a8b-bd49-f4a5744287a5)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/1f0e887e-f7b8-4f15-9a39-07009e468da4)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/a91ae649-ff38-438f-af83-6143c963a04b)
![image](https://github.com/mmruano/MoragriegaRuanoMApi2Ev/assets/146729468/ad171fb5-9abc-4065-9854-87fbd03049a3)
