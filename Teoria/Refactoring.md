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
- 
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
-  **[Feature Envy](#feature-envy)**
-
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

# Cod Smells

## Feature Envy
Ocurre cuando un método accede más a los datos de otro objeto que a su propios datos. Por supuesto, existen varios patrones que sofisticados que rompen esta regla como Strategy and Visitor de GoF.

### Tratamiento
Como regla básica si las cosas cambian al mismo tiempo, se deben mantener ene el mismo lugar.
  - Si es evidente que un método debe moverse a otro lugar, hay que utilizar **Move Method**.

  - Si solo una parte de un método accede a los datos de otro objeto, hay que utilizar **Extract Method** para mover la parte en cuestión.

  - Si un método utiliza funciones de varias otras clases, primero hay que determinar que clase contiene la mayor parte de los datos utilizados. Luego colocar el método en esta clase junto con los demás datos. Y en alternancia usar **Extract Method** para divir el método en varias partes que se puedan colocar en diferentes lugares en diferentes clases.


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

