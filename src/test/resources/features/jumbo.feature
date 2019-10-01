Feature: por menu - supermercado - despensa
  comprar un producto de cada una de las categorias sin superar los 200.ooo$ uno por cada categoria hasta acabar el dinero
  configurar metodo de entrega (recoge en tienda) por parametros (para este caso antioquia - medellin - tienda las vegas)
  compra minima de 20 productos
  validar finalmente contra el carrito de compras (suponiendo que esta por acabar el dinero)
  Scenario Outline:
    Given se debe seleccionar la categoria para comprar productos de despensa <id>
    When  se debe seleccionar un producto por categoria hasta acabar el dinero <id>
    Then  configuro metodo de entrega y valido el carrito de compras <id>
    Examples:
      |id |
      |1  |
