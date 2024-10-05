md_content = """
# Aplicación para la Gestión de un Supermercado con Proveedores y Empleados

## Requerimientos:

### 1. Administrar Productos:
- Cada producto tiene los siguientes atributos:
  - Código, nombre, categoría (alimentos, limpieza, etc.), precio, cantidad en stock, fecha de vencimiento (si aplica), proveedores asociados.
- Crear productos y agregarlos al inventario.
- Consultar datos de un producto dado su código o nombre.
- Actualizar el stock de un producto (añadir o restar unidades).
- Consultar los productos próximos a vencer (dentro de 7 días o menos).
- Consultar productos por categoría (filtrar alimentos, limpieza, etc.).
- Relacionar productos con proveedores: al crear un producto, se deben asociar uno o más proveedores que lo suministren.

### 2. Administrar Clientes:
- Cada cliente tiene los siguientes atributos:
  - Nombre, cédula, teléfono, historial de compras.
- Crear clientes.
- Consultar el historial de compras de un cliente.
- Consultar el cliente que ha gastado más en el supermercado.

### 3. Administrar Proveedores:
- Cada proveedor tiene los siguientes atributos:
  - Nombre, identificación (código de proveedor), teléfono, lista de productos que suministra.
- Crear proveedores.
- Consultar datos de un proveedor dado su código o nombre.
- Consultar los productos suministrados por un proveedor.
- Agregar o eliminar productos de la lista de suministros de un proveedor.
- Asociar productos con proveedores: los productos se deben asociar a uno o más proveedores.
- Actualizar el precio de un producto automáticamente cuando el proveedor lo modifique.

### 4. Administrar Empleados:
- Cada empleado tiene los siguientes atributos:
  - Nombre, identificación (cédula), teléfono, salario, antigüedad.
- Crear empleados.
- Consultar datos de un empleado dado su identificación.
- Calcular la bonificación de un empleado basada en su antigüedad (por ejemplo, un porcentaje del total de ventas).
- Mostrar la cantidad de ventas realizadas por cada empleado.

### 5. Gestionar Ventas:
- Crear ventas de productos a clientes.
- Adicionar productos a una venta (actualizar el stock automáticamente).
- Calcular el total de la venta.
- Consultar ventas por cliente, incluyendo productos comprados, total gastado y fecha de la compra.
- Consultar el total de ingresos del supermercado.

### 6. Reportes:
- Mostrar los 5 productos más vendidos.
- Mostrar el total de ventas en un rango de fechas.
- Mostrar el total de ingresos generados en un mes.
- Mostrar el producto con menos stock disponible.
- Mostrar clientes con más de 3 compras.
- Consultas de proveedores:
  - Consultar qué proveedor(es) suministra(n) un producto dado su código.
  - Consultar qué proveedor tiene más productos asociados.
  - Consultar qué productos han sido solicitados más veces a un proveedor.
- Consultas de empleados:
  - Mostrar los empleados con más ventas.
  - Calcular el total de dinero a pagar a los empleados basado en sus comisiones.
"""

# Guardando el contenido en un archivo .md
file_path = "/mnt/data/supermercado_taller.md"
with open(file_path, "w") as file:
    file.write(md_content)

file_path
