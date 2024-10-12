
# Conversor de Monedas
El Conversor de Monedas es una aplicación de consola desarrollada en Java que permite realizar conversiones entre diferentes monedas utilizando tasas de cambio en tiempo real a través de la API de ExchangeRate. La aplicación ofrece una interfaz interactiva que facilita la selección de monedas y el ingreso de montos, brindando a los usuarios una experiencia simple y fluida. Además, la aplicación guarda un historial de conversiones con marcas de tiempo, permitiendo a los usuarios consultar y gestionar sus conversiones recientes.
## Índice

- [Características](#características)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Requisitos](#Requisitos)
- [Dependencias](#dependencias)
- [Instalación](#instalación)
- [Uso](#uso)
- [Ejemplo de Uso](#ejemplo-de-uso)
- [Créditos](#créditos)

## Características
* Conversión de monedas en tiempo real: Conecta con la API de ExchangeRate para obtener las tasas de conversión actualizadas.
* Interfaz de usuario amigable: Menús interactivos para seleccionar monedas de forma sencilla.
* Historial de conversiones: Guarda las conversiones realizadas con información de la fecha y hora.
* Limpieza del historial: Opción para borrar el historial de conversiones.
* Soporte para múltiples monedas: Incluye las principales monedas internacionales y latinoamericanas.
## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

* api: Contiene las clases relacionadas con la interacción con la API de ExchangeRate.

    * ApiClient: Gestiona las solicitudes a la API y obtiene las tasas de conversión entre monedas.
    * ApiResponse: Representa la respuesta de la API, incluyendo detalles sobre las tasas de conversión y el estado de la solicitud.

* modelos: Incluye las clases que modelan los datos y el historial de conversiones.

    * ConversionRecord: Representa un registro de conversión con el monto original, moneda de origen, monto convertido, moneda destino, y la marca de tiempo.
    * ConversionHistory: Gestiona el historial de conversiones realizadas, permitiendo almacenar y mostrar las conversiones anteriores.

* ui: Contiene la lógica de interacción con el usuario.

    * CurrencyConverterApp: Controla la ejecución principal del programa y la interacción a través de la consola, incluyendo la presentación de menús y el manejo de entradas del usuario.
    * Main: Punto de entrada de la aplicación, donde se inicializa el programa y se llama a la clase CurrencyConverterApp para comenzar la interacción con el usuario.

## Requisitos

Antes de ejecutar este proyecto, asegúrate de tener lo siguiente:

1. **Java 11** o superior instalado.
## Dependencias

Este proyecto utiliza las siguientes dependencias externas que deben incluirse manualmente:

- **Gson**: Biblioteca para la serialización y deserialización de JSON. Debe descargarse desde [Gson GitHub](https://github.com/google/gson) e incluir el archivo `.jar` en el proyecto.



## Instalación

1-Clona el repositorio:

```bash
  git clone https://github.com/Seb-RM/Alura-Conversor-de-monedas.git

```
2-Navega al directorio del proyecto.

```bash
  cd Alura-Conversor-de-monedas

```
3-Configura tu API Key.

* Asegúrate de crear un archivo `config.properties` en la carpeta `src` y agregar tu clave de API en el siguiente formato:

```bash
  API_KEY=tu-clave-api

```
4-Ejecutar el proyecto

Una vez que hayas agregado todas las dependencias necesarias, puedes compilar y ejecutar el proyecto. Si estás utilizando un IDE, solo selecciona la opción `Run`.

¡Y eso es todo! El proyecto ahora está listo.


## Uso
1- Al iniciar la aplicación, se presentará un menú con las siguientes opciones:

* Realizar conversión: Permite seleccionar dos monedas y un monto para convertir.
* Ver historial de conversiones: Muestra un listado de las últimas conversiones realizadas.
* Limpiar historial: Borra todo el historial de conversiones.
* Salir: Cierra la aplicación.

2- Seleccionar monedas: Elige entre una lista de monedas internacionales y latinoamericanas, con un menú claro y amigable.

3- Resultados claros: Después de realizar la conversión, se mostrará el monto convertido y la tasa de cambio utilizada.

# Ejemplo de Uso

```bash
****************************************
Bienvenido al Conversor de Monedas
****************************************

========================================
Seleccione una opción:
1. Convertir moneda
2. Ver historial de conversiones
3. Limpiar historial
4. Salir
========================================
Selecciona una opción: 1

========================================
* Elige la primera moneda (origen):
1. USD - Dólar estadounidense
2. EUR - Euro
3. GBP - Libra esterlina
4. JPY - Yen japonés
5. AUD - Dólar australiano
6. CAD - Dólar canadiense
7. ARS - Peso argentino
8. BRL - Real brasileño
9. CLP - Peso chileno
10. COP - Peso colombiano
11. MXN - Peso mexicano
12. PEN - Sol peruano
========================================

* Ingresa el número de tu elección: 1
* Has seleccionado: USD
========================================

========================================
* Elige la moneda a la que quieres convertir:
2. EUR - Euro
3. GBP - Libra esterlina
4. JPY - Yen japonés
5. AUD - Dólar australiano
6. CAD - Dólar canadiense
7. ARS - Peso argentino
8. BRL - Real brasileño
9. CLP - Peso chileno
10. COP - Peso colombiano
11. MXN - Peso mexicano
12. PEN - Sol peruano
========================================

* Ingresa el número de tu elección: 2
* Has seleccionado: EUR
========================================

¿Cuánto deseas convertir? 
========================================
Ingresa el monto: 100

****************************************
* Resultado de la conversión:
* 100,00 USD equivalen a 91,42 EUR
* Tasa de conversión: 1 USD = 0,9142 EUR
****************************************

========================================
Seleccione una opción:
1. Convertir moneda
2. Ver historial de conversiones
3. Limpiar historial
4. Salir
========================================
Selecciona una opción: 

```
## Créditos

* API de conversión de monedas proporcionada por ExchangeRate API.API de conversión de monedas proporcionada por [ExchangeRate API](https://www.exchangerate-api.com/).
