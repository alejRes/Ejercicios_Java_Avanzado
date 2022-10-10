# Patrones de Diseño:

## ¿Que son?

Son soluciones que se utilizan para resolver problemas que ocurren con frecuencia y que siempre se resuelven de la misma
manera.
Los patrones de diseño se pueden catalogar en 3 categorias:

1. Los **patrones creacionales** son aquellos que que nos ayudan a la hora de crear instancias de clase (crear objetos).
   Permiten crear objetos complejos de una forma más fácil, nos dan más flexibilidad y podemos reutilizar código ya
   escrito.
2. Los **patrones estructurales** solucionan la unión de clase y objetos en estructuras más grandes y complejas.
3. Los **patrones de comportamiento** proporcionan soluciones respecto a la iteración de objetos y cómo se comunican.

Dentro de cada tipo de patrón existen varios modelos que vamos a explicar a continuación.

### Patrones creacionales:

* **Singleton**: Permite que de una clase solo haya una única instancia.
  Un ejemplo es crear una clase que se encargue de las conexiones, en el momento que se crea
  una instancia de una conexión no te va a permitir crear otra.

```java
public class MiConexion {
    private static MiConexion miConexion;

    private MiConexion() {
    }

    public static MiConexion getInstance() {
        if (miConexion == null) {
            miConexion = new MiConexion();
        }
        return miConexion;
    }
}
```

* **Factory**: Sirve para crear una jerarquía de clases y utilizar la que necesitemos de forma transparente. Normalmente
  se comienza definiendo una interfaz o clase abstracta
  en la cual definimos el método que luego van a implementar las demás clases.

  Soluciona el problema de generar objetos sin especificar su clase concreta.

```java
public interface FiguraGeometrica {
    public double getArea();
}

class Rectangulo implements FiguraGeometrica {
    double alto;
    double ancho;

    public Rectangulo(double... medidas) {
        this.alto = medidas[0];
        this.ancho = medidas[1];
    }

    @Override
    public double getArea() {
      System.out.println("Area del rectangulo");
        return alto * ancho;
    }
}

class Circulo implements FiguraGeometrica {
    double radio;
    
    public Circulo(double... medidas){
        this.radio = medidas[0];
    }

    @Override
    public double getArea() {
      System.out.println("Area del circulo");
        return 2 * Math.PI * radio;
    }
}

class FigurasFactory{
    FiguraGeometrica figura;
    private FiguraFactory(){}
  
    public FiguraFactory(double... medidas){
        if (medidas.length == 2){
            figura = new Rectangulo(medidas);
        } else if (medidas.length == 1) {
            figura = new Circulo(medidas);
        }else{
          System.out.println("no hay digura con ese numero de parametros");
        }
    }
    
    public double areaFigura(){
        return figura.getArea();
    }
}

public class Main(){
  public static void main(String[] args) {
    FigurasFactory figurasFactory = new FigurasFactory(1,2);
    double area = figurasFactory.areaFigura();
  }
}
```

* **Builder**: Nos permite construir objetos complejos paso a paso, en vez de utilizar un constructor con muchos
  parametros.

  El patrón organiza una serie de pasos y lo más importante es que no necesitas
  ejecutar todos los pasos para la creación de un objeto particular.
  Permite la programación fluida.

```java
class KitMontaje {
    private int cantidadTuercaCuadrada;
    private int cantidadTuercaPequenia;
    private int cantidadTuercaGrande;
    private int cantidadTornilloCuadrado;
    private int cantidadTornilloPequenio;
    private int cantidadTornilloGrande;
    private int cantidadArandelaCuadrada;
    private int cantidadArandelaPequeña;
    private int cantidadArandelaGande;
    private int cantidadTablasPequeñas;
    private int cantidadTablasGrandes;
    
    /* hay que añadir los setters de las propiedades para que sean accesibles
    y se puedan modificar */
}

class KitMontajeBuilder {
    private KitMontaje kitMontaje;

    public KitMontajeBuilder() {
        kitMontaje = new KitMontaje();
    }

    public KitMontajeBuilder setCantidadTornilloCuadrado(int cantidad) {
        kitMontaje.setCantidadTornilloCuadrado(cantidad);
        return this;
    }

    public KitMontajeBuilder setCantidadTornilloPequenio(int cantidad) {
        kitMontaje.setCantidadTornilloCuadrado(cantidad);
        return this;
    }

    public KitMontajeBuilder setCantidadTornilloGrande(int cantidad) {
        kitMontaje.setCantidadTornilloCuadrado(cantidad);
        return this;
    }
    //...
    //hacer un metodo por cada setter de la clase que queremos hacer el builder

    public KitMontaje builder() {
        return this.kitMontaje;
    }
}

public class Main {
    public static void main(String[] args) {
        //utilización del Buider

        KitMontaje miKit = new KitMontajeBuilder()
                .setCantidadTornilloCuadrado(3)
                .setCantidadTornilloCuadrado(4)
                .builder();
    }
}
```

* **Prototype**: Su objetivo es poder clonar una clase y que este clon herede todos los metodos y propiedades, además
  también clona su estado.

```java
class Personaje {
    private String nombre;
    private String equipo;
    private String posicion;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }
    //añadir más constructures según la necesidad

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }
    //añadir los demás setters y getters

    //metodo que permite clonar el objeto

    public Personaje clonar() {
        return new Personaje(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Personaje p1 = new Personaje("mi personaje");
        Personaje pesonajeClonado = p1.clonar();
    }
}
```
### Patrones estructurales

* **Decorator**: Permite añadir funcionalidad a una clase ya existente, es una forma de superar las limitaciones de la herencia.
Se puede decorar el objeto con todos los decoradores que queramos mientras que cada uno de estos decoradores tengan implimentanda la misma interfaz que el anterior
Un caso de uso puede ser en un sistema de notificaciones donde segun los decoradores que se utilicen pueden enviarse diferentes tipos de notificaciones.


* **Adapter**: Consiste en que clases que tienen implementaciones distintas logren trabajar baja la misma interfaz.
Esconde la complejidad de la conversión por detrás y el objeto que es envuelto no se da cuenta de la existencia del adaptador.

  Un adaptador es una clase intermedia que hace que código que código heredado pueda funcionar en nuestra aplicación, se crea un adaptador por cada clase que queremos acoplar a nuestra funcionalidad.


* **Facade**: Es un patron que es como un envoltorio que simplifica el uso de un grupo de clases más complejas.
  
  