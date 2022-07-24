# ejercicio-redmond

# API endpoints

Estos endpoint permitiran interactuar con la funcionalidad de la API.

### GET /empleado/sueldo?nombre=Javier
Obtiene cantidad de billetes necesarios de cada denominación para armar el sobre que se le debería entregar a principio de mes, utilizando la menor cantidad de billetes posibles.
Las nominaciones de billetes a utilizar son de 1, 2, 5, 10, 20, 50 y 100 pesos.

**Parámetros**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `nombre` | required | string  | El nombre del empleado. <br/><br/>                                                                    |                                                                     |

**Respuesta**

```
// Cantidad de billetes de cada denominación.
{
    "100": 964,
    "1": 0,
    "2": 1,
    "5": 0,
    "50": 1,
    "20": 0,
    "10": 1
}

o algun mensaje de error

{
    "timestamp": "2022-07-24T03:19:40.690+00:00",
    "status": 400,
    "error": "Mensaje de error",
    "path": "/empleado/sueldo"
}
```
___

### GET /empleado/reporte
Obtiene un reporte de sueldos totales y cantidad de empleados.

**Respuesta**

```
// Promedio de total de sueldos, total de sueldos a liquidar y cantidad de empleados a con sueldos a liquidar.
{
    "promedio": 114163.33333333333,
    "total": 342490.0,
    "empleados": 3.0
}

o algun mensaje de error

{
    "timestamp": "2022-07-24T03:19:40.690+00:00",
    "status": 400,
    "error": "Mensaje de error",
    "path": "/empleado/reporte"
}
```
___

### GET /empleado/lista?page=0&size=10
Obtiene una lista paginada de empleados con sus respectivos datos.

**Parámetros**

|          Name | Required |  Type   | Description                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `page` | required | int  | Número de página. <br/><br/> Valores posibles: >=0.                                                                     |                                                                     |
|     `size` | required | int  | Tamaño de página. <br/><br/> Valores posibles: >=1.                                                                     |                                                                     |

**Respuesta**

```
// Lista paginada de empleados con legajo, nombre y sueldo.
{
    "content": [
        {
            "legajo": 1236,
            "nombre": "Dario",
            "sueldo": 113293.0
        },
        {
            "legajo": 1235,
            "nombre": "Facundo",
            "sueldo": 132735.0
        },
        {
            "legajo": 1234,
            "nombre": "Javier",
            "sueldo": 96462.0
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "empty": false,
            "unsorted": false
        },
        "pageNumber": 0,
        "pageSize": 10,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 3,
    "sort": {
        "sorted": true,
        "empty": false,
        "unsorted": false
    },
    "size": 10,
    "number": 0,
    "numberOfElements": 3,
    "first": true,
    "empty": false
}

o algun mensaje de error

{
    "timestamp": "2022-07-24T03:19:40.690+00:00",
    "status": 400,
    "error": "Mensaje de error",
    "path": "/empleado/lista"
}
```
___
