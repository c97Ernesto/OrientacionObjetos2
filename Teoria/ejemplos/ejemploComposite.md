```java
/* Interfaz COMPONENT: declara operaciones común tanto para
los objetos simples (LEAF) y complejos (COMPOSITE). */
public class Topografia {

    public abstract proporcionDeAgua();

    

}
```

```java
/* LEAF: representan los objetos finales de una composición. Normalmente
son estos objetos los que hacen el trabajo real.*/
public class Agua {    
    public double proporcionDeAgua(){
        return 1;
    }
}

public class Tierra {
    public double proporcionDeAgua(){
        return 0;
    }
}
```

```java
/* COMPOSITE: representa a los componentes complejos que pueden tener hijos. Normalmente 
son estos objetos los que delegan recursivamente el trabajo real a sus hijos*/
public class Mixta {

    //listado de los tipos de topografias
    private List<Topografia> partes;
    
    public double proporcionDeAgua(){
        return this.totalDeAgua / partes.size()
    }

	// Accedemos recursivamente a todos los hijos y 
    // obtenemos la porción de Agua según la topografía
    public double totalDeAgua(){
        return this.partes.stream()
            .mapToDouble(parte -> parte.proporcionDeAgua())
            .sum();
    }
}
```