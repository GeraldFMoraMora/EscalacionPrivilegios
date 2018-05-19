# SEGUNDA TAREA CORTA
## Ataque por escalación de privilegios por uso transitivo en Android
Ataque por escalación de privilegios por uso transitivo con el permiso de escritura en almacenamiento externo.

## Requerimientos recomendados del sistema
- Sistema operativo Android, version minima API 15 () o hasta la version maxima API 19 ().
- Memoria RAM: 2GB (Recomendado).
- Pantalla de 4.7" (Recomendado).
- Tarjeta SD (Obligatorio, al menos 2GB).

## Agregar permiso de escritura en almacenamiento externo
- El desarrollador debe crear la aplicación Android (vacía) desde Android Studio.
- Desde el archivo `AndroidManifest.xml` se debe agregar el permiso para la escritura en almacenamiento externo que se presenta a continuación.
```xml
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
## Agregar el Broadcast Receiver en Android
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
