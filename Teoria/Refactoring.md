<h1 align="center">Refactoring</h1>

El Refactoring es una **tranformación** que preserva el comportamiento, pero mejora el diseño.

También se lo puede denominar como un **proceso** a través del cual se cambia un sistema se software.
  - para _mejorar_ la organización, legibilidad, adaptabilidad y mantenibilidad del código luego que ha sido escrito.
  - que _NO altera_ el comportamiento externo del sistema.

### Características del Refactoring



### Cods Smells

#### Bloaters
- Long Method
- Large Class
- Long Parameter List
- [Primitive Obsession](#primitive-obsession)
-

#### Object-Orientation Abusers
- Switch Statements
- **[Temporary Field](#temporary-field)**
-
-

#### Change Preventers
- 

#### Dispensables
- Comments
- Duplicate Code
- Lazy Class
- Data Class
- 
-

#### Couplers
- **[Feature Envy](#feature-envy)**
- **[Inappropiate Intimacy](#inappropiate-intimacy)**
-
-

### Refactorings

#### Simplifying Method Calls
- **[Rename Method](#rename-method):**
  - _Problema_: El nombre del método no es lo suficientemente explicativo para deducir que función cumple.
  - _Solución_: Renombrar el método.

#### Simplifying Conditional Expressions
- **[Replace Conditional with Polymorphism](#replace-conditional-with-polymorphism):**
  - _Problema_: Hay un condicional que realiza varias acciones según el tipo de objeto o las propiedades.
  - _Solución_: Crear subclases que coincidan con las ramas del condicional. El resultado es que la implementación adecuada se logrará mediante polimorfismo dependiendo de la clase objeto.

#### Moving Features between Objects
- **[Move Method](#move-method):**
  - _Problema_: Un método es utilizado más en otra clase que en su propia clase.
  - _Solución_: Crear un nuevo método en la clase que más lo use y luego mover el código del método anterior a esa clase. Convertir el código del método original en una referencia al nuevo método en la otra clase o eliminarlo por completo.

#### Organization Data
- **[Replace Type Code with Subclasses](#replace-type-code-with-subclasses):**
  - _Problema_: Se usan valores primitivos para condicionales en métodos.
  - _Solución_: Crear Subclases para reemplazar los valores primitivos. Luego extraer comportamiento relevante de la clase original. Y por último reemplazar el algoritmo condicional con polimorfismo.

- **[Replace Data Values with Object](#replace-data-values-with-object):**
  - _Problema_: Una clase o grupo de clases tienen un campo donde ese campo tiene su propio comportamiento y datos asosciados.
  - _Solución_: Se crea una clase, colocando el campo anterior y su comportamiento en la clase y almacenar el objeto de la clase en la clase original.

#### Composing Methods
- **[Extract Method](#extract-method)**
  - _Problema_: Tener un fragmento de código que se puede agrupar.
  - _Solución_: Mover el código a un nuevo método o función independiente y reemplazar el código anterior con una llamada al método.

- **[Replace Temp with Query](#replace-temp-with-query)**
  - _Problema_: Colocar el resultado de una expresión en una variable local para su uso posterior en su código.
  - _Solución_: Movel la expresión completa a un método separado y devolver el resultado. Consultar el método en lugar de utilizar la variable.

- **[Replace Loop with Pipeline](#replace-loop-with-pipeline)**
  - _Problema_: ... 
  - _Solución_: ...

#### Dealing with Generalization
- **[Pull Up Method](#pull-up-method)**
  - _Problema_: Las subclases tienen métodos que realizan el mismo trabajo. 
  - _Solución_: Hacer en un mismo método el mismo trabajo que realizan las sublcases y moverlos a la superclase relevante.

- **[Form Template Method](#form-template-method)**
  - _Problema_: Las subclases implementan algoritmos que tienen pasos similares en el mismo orden. 
  - _Solución_: Mover la estructura del algoritmo y los pasos similares a una superclase dejando la implementación de los diferentes pasos en las subclases.

# Refactorings

## Rename Method
### Pasos para la refactorización
1. Verificar si el método se encuentra definido en una superclase o subclase. Si es así repetir los pasos en esas clases.
2. Crear un nuevo método con un nombre nuevo.
    - Copiar el código del método anterior.
    - Eliminar todo el código del método anterior y, en su lugar, insertar una nueva llamada para el nuevo método.
3. Encontrar todas las referencias al método anterior y reemplazarlas con la referencia del nuevo método.
4. Eliminar el método anterior
    - Si el método anterior forma parte de una interfaz pública, no realizar este paso y directamente marcar el método anterior como obsoleto.

## Replace Temp with Query
Esta refactorización puede sentar las bases para aplicar _Extract Method_ en alguna parte de un método demasiado largo
### Pasos para la refactorización
1. Asegurarse de que se asigne un valor a la variable una vez y sola una vez dentro del método. De lo contrario, usar **Split Temporary Variable** para asegurarse de que la variable se use solo para almacenar el resultado de la expresión.

2. Utilizar **Extrar Method** para colocar la expresión de interés en un nuevo método. Asegurarse de que este método solo devuelva un valor y no cambie el estado del objeto. Si el método afecta al estado visible del objeto, utilizar Separete **Query from Modifier**.

## Replace Loop with Pipeline
Reemplazar estructuras de bucles por una colección de pipelines


## Move Method
- Cuando movemos un método a una clase que contenga la mayoría de los datos utilizados por el método, haciendo que las clases sean más coherentes internamente.
- Cuando movemos un método para reducir o eliminar la dependencia de la clase que llama al método de la clase en la que se encuentra. Esto puede resultar útil si la clase que llama ya depende de la clase a la que planea mover el método.

### Pasos para la refactorización
1. Inspeccionar que dependencias y otros miembros de la clase utilizan el método. Decidir si tambien necesitan ser movidos.

2. Comprobar si una superclase o subclase hace referencia al método en cuestión. Si lo usan, tal vez no sea posible mover el método.

3. Crear el método en la clase destino y copiar el código existente en él. Si el método movido usa una instancia de la clase original, se podría pasar como parámetro del método.

4. Eliminar el código del método anterior y delegar la llamada al nuevo método.

5. Opcionalmente decidir si se desea eliminar el método anterior y llamar al nuevo método directamente.

## Extract Method
### Pasos para la refactorización
1. Crear un nuevo método y asignarle un nombre descriptivo en cuanto a su propósito.

2. Copiar el fragmento del código que considere relevante al nuevo método. Eliminar el fragmente de donde se encontraba ubicado, y en su lugar, podría realizar una llamada al nuevo método desde allí.

3. Encontrar todas las variables utilizadas en ese fragmento de código. Si se declaran dentro del fragmento y no se usan fuera de él, solamente dejarlas sin cambios, de esta manera se convertirán en variables locales al nuevo método.

4. Si las variables se declaran antes del código que se extrajo, se deberán pasar como parámetros al nuevo método. Otra manera de solucionar esto podría ser deshaciendo las variables recurriendo a **Replace Temp with Query**

## Pull Up Method
### Mecánica
1. Investigar los métodos los métodos idénticos. Si hacen lo mismo pero no son idénticos, formatearlos para que tengan un cuerpo idéntico.

2. Verificar todas las llamadas de métodos y referencias de variables dentro del cuerpo del método.

3. Si los métodos tienen diferentes firmas, usar **Change Function Declaration** para llevarlos a la superclase.

4. Crear un nuevo método en la superclase, copiar el cuerpo de uno de los métodos.

5. Correr los test.

6. Eliminar un método de la subclase.

7. Probar.

8. Eliminar los demás métodos de las sublcases.

### Ejemplo
```java
class Employee {...}

class Salesman extends Employee {
  get name() {...}
}

class Engineer extends Employee {
  get name() {...}
}
```
#### Después de aplicar Pull Up Mehtod:
```java
class Employee {
  get name() {...}
}

class Salesman extends Employee {...}
class Engineer extends Employee {...}
```


## Replace Conditional with Polymorphism
Para esta técnica tiene que haber una jerarquía de clases que contendrán comportamientos alternativos. Si no la hay se derberá crear.

Habra que reemplazar el código de tipo con subclases y crear subclases para todos los valores de una propiedad de objeto en particular.

### Tratamiento
1. Si el condicional está en un método que también realiza otras acciones, aplicar **Extract Method**.

2. Para cada subclase de la jerarquía, redefinir el método que contiene el condicional y copiar el código de la rama condional correspondiente en esa ubicación.

3. Eliminar la rama del condicional.

4. Repetir el reemplazo hasta que el condicional se encuentre vacío.

## Form Template Method
Cuando hay métodos en varias clases que comparten un algoritmo similar con pasos específicos que varían. O cuando se desea estandarizar el flujo de un algoritmo, permitiendo que las subclases definan los detalles de ciertos pasos.


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

## Replace Type Code with Subclasses
Éste refactoring se usa cuando el comportamiento asociado con un tipo e código está intrínsecamente asociado a la clase base y se maneja mejor mediante la herencia

### Mecánica
1. Encapsulamos el campo que contiene el código de tipo con un método getter. Este paso garantiza que todos los accesos al campo tipo se realicen a través del método.

2. Convertimos en privado el constructor de la clase y creamos un método que seleccione la clase apropiada según el tipo.

3. Creamos una subclase única para cada valor del tipo primitivo

4. Eliminamos el campo con código de tipo primitivo de la superclase. Convertimos en abstarcta la clase padre.

5. Movemos los campos y métodos de la superclase a las subclases correspondientes utilizando Push Down Field y Push Down Method

6. Usamos Replace Conditional with Polimorphism para deshacerse de las condiciones que usan el código de tipo.

## Replace Data Values with Object

### Tratamiento
Antes de comenzar, verificar si hay referencias directas a la variable dentro de la clase. Si es así utilizar **Self Encapsulate** para ocultarlo de la clase original.

1. Crear una nueva clase y copiar el campo y un getter. Crear un constructor que acepte el valor del campo. Esta clase no tendrá un setter, ya que cada nuevo valor del campo que se envíe a la clase original creará un nuevo objeto de la variable.

2. En la clase original, campiar el tipo del campo a la nueva clase.

3. En el getter de la clase original, invocar al getter del objeto asociado.

4. En el setter crear un nuevo valor del objeto. También es posible crear un nuevo objeto en el constructor si los valores iniciales se habían establecido ahí con anterioridad para el campo.

###

# Cod Smells

## Feature Envy
Ocurre cuando un método accede más a los datos de otro objeto que a su propios datos. Por supuesto, existen varios patrones que sofisticados que rompen esta regla como Strategy and Visitor de GoF.

### Tratamiento
Como regla básica si las cosas cambian al mismo tiempo, se deben mantener ene el mismo lugar.
  - Si es evidente que un método debe moverse a otro lugar, hay que utilizar **Move Method**.

  - Si solo una parte de un método accede a los datos de otro objeto, hay que utilizar **Extract Method** para mover la parte en cuestión.

  - Si un método utiliza funciones de varias otras clases, primero hay que determinar que clase contiene la mayor parte de los datos utilizados. Luego colocar el método en esta clase junto con los demás datos. Y en alternancia usar **Extract Method** para divir el método en varias partes que se puedan colocar en diferentes lugares en diferentes clases.

## Inappropiate Intimacy
Una clase se encuentra utilizando variables internas de otra clase

### Tratamiento
- Una de las soluciones es utilizar **Move Method** y **Move Field** para mover las partes de una clase a la clase en las que se utilizan esas partes. Pero solamente si la primera clase no necesita esas piezas.

- Otra solución sería utilizar **Extract Class** y **Hide Delegate** para hacer que las relaciones del código sean "oficiales".

- Si las clases son interdependientes entre si, utilizar **Change Bidirectional Association to Unidirectional**.

- Si se da entre una subclase y una superclase, reemplazar la delegación con herencia.

###


## Temporary Field
A menudo, las variables temporales se crean para su uso en el algoritmo cuando requiere una gran cantidad de entradas. Entonces en lugar de crear varios parámetros en el método, se decide crear variables temporales para éstos datos en la clase o método. Estas variables solo son utiliazadas en el algoritmo y depués no se vuelven a utilizar.

### Signos y Síntomas
- Campos con uso limitado: observar que ciertos campos dentro de una clase se usan solo temporalmente o durante métodos específicos.

- Campos no utilizados: los campos que no se utilizan durante todo el ciclo de vida del objeto o clase pueden ser campos temporales.

- Asignación condicional: campos a los que se les asignan valores solo bajo condiciones específicas o dentro de ciertos métodos.

- Código desordenado: la presencia de campos temporales puede desordenar el código, haciéndolo más difícil de entender y mantener.

- Alta complejidad ciclomática: el código con campos temporales a menudo tiene una mayor complejidad ciclomática, lo que lleva a pruebas y depuración más complejas.

### Razones del problema

- Abstracción incompleta: los campos temporales pueden resultar de una abstracción incompleta cuando los desarrolladores crean clases sin una comprensión clara de los datos y el comportamiento requeridos.

- Requisitos cambiantes: a medida que cambian los requisitos, los campos que inicialmente estaban destinados a ser permanentes pueden volverse temporales, pero el código no se actualiza en consecuencia.

- Variables globales: en algunos casos, los campos temporales se pueden utilizar como solución alternativa a la falta de encapsulación o transferencia de parámetros adecuada.

- Falta de encapsulación: los desarrolladores no pueden encapsular datos temporales dentro de clases o métodos más pequeños y enfocados, lo que lleva a campos que se usan solo temporalmente.

### Tratamiento
- Los campos temporales y todo el código que opera en ellos se pueden colocar en una clase separada mediante **Extract Class/Method**. En otras palabras, está creando un objeto de método y logrando el mismo resultado que si realizara **Remplace Method/Move Function** con objeto de método.

- Introducir **Null Object** e integrarlo en lugar del código condicional que se utilizó para verificar la existencia de los valores de los campos temporales.

## Primitive Obsession
Los tipos primitivos a menudo se utilizan para "simular" tipos. Estos tienen un conjunto de números o strings que forman la lista de valores permitidos para alguna entidad.

- Uso de variables de tipo primitivo en lugar de objetos.
- Uso de constantes para codificar información (USER_ADMIN_ROLE = 1) para hacer referencia a usuarios con derechos de administrador.
- Uso de constantes de String como nombres de variables.

### Tratamiento
- Su hay una gran variedad de campos primitivos, es posible agrupar lógicamente algunos de ellos en su propia clase. Se podría mover el comportamiento asociado con estos datos a la clase también. Se podría utilizar **Replace Data Value with Object**.

- Si los valores de las variabels primitivas se utilizan como parámetros, se podría utilizar **Introduce Parameter Object** o **Preserve Whole Object**.

- Cuando se codifican datos complicados en variables, utilizar **Replace Type Code with Class**, **Replace Type Code with Subclasses**, **Replace Type Code with State** o **Replace Type Code with Strategy**