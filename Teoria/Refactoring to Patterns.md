 
# Refactoring to Patterns

<h2 align="center">Smells</h2>

#### Conditional Complexity
- Move Embellishment to Decorator
- Replace Conditional Calculations with Strategy
- Replace State-Altering Conditionals with State

#### Combinatorial Explosion
- Replace Conditional Searches with Specification

#### Duplicate Code
- Chain Constructors
- Introduce Polymorphic Creation with Factory Method

#### Inappropriate Intimacy
- Encapsulate Composite with Builder

#### Indecent Exposure
- Encapsulate Classes with Creation Methods

#### Large Class
- Extract Creation Class

#### Long Method
- Compose Method
- Move Accumulation to Collecting Parameter

#### Longer Parameter List
- Replace Conditional Calculations with Strategy

#### Primitive Obsession
- Replace Implicit Tree with Composite
- Replace Conditional Calculations with Strategy
- Replace Enum with Type-Safe Enum
- Replace State-Altering Conditionals with State
- Replace Conditional Searches with Specification

#### Switch Statement
- Replace Conditional Calculations with Strategy


<h2 align="center">Refactoring</h2>

## Form Template Method
Cuando hay dos métodos en subclases que realizan los mismos pasos, pero hacen cosas distintas en cada paso, crear métodos para esos pasos con la misma firma y mover el método original a la clase base.


### Mecánica
1. Encontrar el método que es similar en todas las subclases y extraer sus partes en: métodos idénticos (misma signatura y cuerpo en las subclases) o métodos únicos (distinta signatura y cuerpo).

2. Aplicar **Pull Up Method** para los métodos idénticos.

3. Aplicar **Rename Method** sobre los únicos hasta que el método similar quede con cuerpo idéntico en las subclases.

4. Compilar y testear después de cada "rename".

5. Aplicar **Rename Method** sobre los métodos similares en las subclases (esqueleto). 

6. Aplicar **Pull Up Method** sobre los métodos similares.

7. Definir métodos abstractos en la superclase por cada método único en las subclases.

8. Compilar y testear.

### Ejemplo

```java
public abstract class Party { }

public class Person extends Party {
  private String firstName;
  private String lastName;
  private Date dob;
  private String nationality;
  public void printNameAndDetails() {
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("DOB: " + dob.toString() + ", Nationality: " + nationality);
  }
}

public class Company extends Party {
  private String name;
  private String companyType;
  private Date incorporated;
  public void PrintNameAndDetails() {
    System.out.println("Name: " + name + " " + companyType);
    System.out.println("Incorporated: " + incorporated.toString());
  }
}
```
#### Después de aplicar refactoring
```java
public abstract class Party {
  public void PrintNameAndDetails() {
    printName();
    printDetails();
  }
  public abstract void printName();
  public abstract void printDetails();
}

public class Person extends Party {
  private String firstName;
  private String lastName;
  private Date dob;
  private String nationality;
  public void printDetails() {
  System.out.println("DOB: " + dob.toString() + ", Nationality: " + nationality);
  }
  public void printName() {
    System.out.println("Name: " + firstName + " " + lastName);  
  }
}

public class Company extends Party {
  private String name;
  private String companyType;
  private Date incorporated;
  public void printDetails() {
    System.out.println("Incorporated: " + incorporated.toString());
  }
  public void printName() {
    System.out.println("Name: " + name + " " + companyType);
  }
}
```

## Replace Conditional Logic with Strategy
### Mecánica

1. Crear una clase Strategy.

2. Aplicar **Move Method** para mover el cálculo con los codicionales del contexto al strategy.

    - Definir una v.i en el contexto para referenciar al strategy y un setter (generalmente el constructor del contexto).
    - Dejar un método en el contructor que delegue.
    - Elegir los parámetros necesarios para pasar al strategi (el contexto entero? Solo algunas variables? Y en que momento?)
    - Compilar y testear.

3. Aplicar **Extract Parameter** en el código del contexto que inicializa un strategy concreto, para permitir a los clientes setear el strategy.

4. Aplicar "Replace Conditional with Polymorphism" en el método del Strategy.

5. Compilar y testear con distintas comninaciones de estrategias y contextos.

## Replace State-Altering Conds. with State
### Mecánica

1. Aplicar **Replace Type-Code with Class** para crear una clase que será la superclase del State a partir de la v.i que mantiene el estado.

2. Aplicar **Extract Subclass** para crear una subclase del State por cada uno de los estados de la clase contexto.

3. Por cada método de la clase contexto con condicionales que cambiar el valor del estado, aplicar **Move Method** hacia la superclase State.

4. Por cada estado concreto, aplicar **Push Down Method** para mover de la superclase a esa subclase los métodos que producen una transición desde ese estado. Sacar la lógica de comprobación que ya no hace falta.

5. Dejarlos estos métodos como abstractos en la superclase o como métodos por defecto.

## Move Embellishment to Decorator
### Mecánica
1. Identificar la superclase o interface del objeto a decorar (clase Component del patrón). Si no existe, crearla.

2. Aplicar **Replace Conditional Logic with Polymorphism** (crear decorador como subclase del decorado).

    - Verifico si con lo que tengo hasta ahora es suficiente.

3. Aplicar **Replace Inheritance with Delegation** (decorador delega en docorado como clase "hermana").

4. Aplicar **Extract Parameter** en decorador para asignar decorado.

## Introduce Null Object
La lógica para mejarse con un valor nulo en una variable está duplicado por todo el código.
