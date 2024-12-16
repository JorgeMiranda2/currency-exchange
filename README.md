
# Conversor de Monedas

Este proyecto es un simple conversor de monedas que permite convertir entre varias divisas utilizando una API de tipo de cambio. El programa está escrito en Java y utiliza la biblioteca `Gson` para manejar el formato JSON.

## Características

- Convertir entre las siguientes divisas:
  - Dólar (USD) ↔ Peso Argentino (ARS)
  - Dólar (USD) ↔ Real Brasileño (BRL)
  - Dólar (USD) ↔ Peso Colombiano (COP)
- Menú interactivo para seleccionar las opciones de conversión.
- Solicita la cantidad a ser convertida y muestra el resultado de la conversión basado en la tasa de cambio actual.

## Requisitos

- [Java](https://www.java.com/es/download/)
- [Gson](https://github.com/google/gson) (para manejar JSON)

## Uso

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/conversor-de-monedas.git
   ```

2. **Navega al directorio del proyecto**:
   ```bash
   cd conversor-de-monedas
   ```
3. **Compila el proyecto:**:
   ```bash
   javac -cp .:gson-2.8.6.jar Main.java APIConnection.java Dtos/Exchange.java

   ```
4. **Ejecuta el proyecto**:
   ```bash
   cd java -cp .:gson-2.8.6.jar Main
   ```

## Demostración

A continuación se muestran algunas capturas de pantalla del programa en funcionamiento:
![ejemplo 1: dolares a pesos colombianos](https://github.com/user-attachments/assets/19f85a12-0bb3-4690-9368-683747e66b5c)
![ejemplo 2: pesos argentinos a dolares](https://github.com/user-attachments/assets/5fb8b531-9c95-4ac6-8aea-2176bcb0e029)
