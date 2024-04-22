1. _**State (Estado)**_

![ejemploState](imgs/StateEjemplo.svg)

```java
// Clase abstracta para definir la interfaz de los estados
abstract class Estado {
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Constructor
    public Estado(Curso curso) {
        this.curso = curso;
    }

    // Métodos abstractos
    public abstract void matricular();
    public abstract void retirarMatricula();
    public abstract void terminarCiclo();
    public abstract void convalidar();
    public abstract void reprobar();
}
```

2. _**Concrete States (NoMatriculado, EnCurso, Terminado)**_
```java
class NoMatriculado extends Estado {
    public NoMatriculado(Curso curso) {
        super(curso);
    }

    @Override
    public void matricular() {
        this.getCurso().cambiarEstado(new EnCurso(this.getCurso()));
        System.out.println("Curso matriculado exitosamente.\nEstado: " + getCurso().getEstadoActual().getClass().getSimpleName());
    }

    @Override
    public void retirarMatricula() {
        super.retirarMatricula();
    }

    @Override
    public void terminarCiclo() {
        super.terminarCiclo();
    }

    @Override
    public void convalidar() {
        getCurso().cambiarEstado(new Terminado(getCurso()));
        System.out.println("Curso convalidado exitosamente.\nEstado: " + getCurso().getEstadoActual().getClass().getSimpleName());
    }

    @Override
    public void reprobar() {
        super.reprobar();
    }
}
```

```java
class EnCurso extends Estado {
    public EnCurso(Curso curso) {
        super(curso);
    }

    @Override
    public void matricular() {
        super.matricular();
    }

    @Override
    public void retirarMatricula() {
        getCurso().cambiarEstado(new NoMatriculado(getCurso()));
        System.out.println("Curso retirado exitosamente.\nEstado: " + getCurso().getEstadoActual().getClass().getSimpleName());
    }

    @Override
    public void terminarCiclo() {
        getCurso().cambiarEstado(new Terminado(getCurso()));
        System.out.println("Curso terminado.\nEstado: " + getCurso().getEstadoActual().getClass().getSimpleName());
    }

    @Override
    public void convalidar() {
        super.convalidar();
    }

    @Override
    public void reprobar() {
        super.reprobar();
    }
}
```

```java
class Terminado extends Estado {
    public Terminado(Curso curso) {
        super(curso);
    }

    @Override
    public void matricular() {
        super.matricular();
    }

    @Override
    public void retirarMatricula() {
        super.retirarMatricula();
    }

    @Override
    public void terminarCiclo() {
        super.terminarCiclo();
    }

    @Override
    public void convalidar() {
        super.convalidar();
    }

    @Override
    public void reprobar() {
        getCurso().cambiarEstado(new NoMatriculado(getCurso()));
        System.out.println("Curso reprobado.\nEstado: " + getCurso().getEstadoActual().getClass().getSimpleName());
    }
}
```

3. _**Context (Curso)**_
```java
class Curso {
    private Estado estadoActual;

    // Constructor
    public Curso() {
        // Estado inicial
        this.estadoActual = new NoMatriculado(this);
    }

    // Métodos para cambiar de estado
    public void cambiarEstado(Estado estado) {
        this.estadoActual = estado;
    }

    // Métodos que delegan en el estado actual
    public void matricular() {
        estadoActual.matricular();
    }

    public void retirarMatricula() {
        estadoActual.retirarMatricula();
    }

    public void terminarCiclo() {
        estadoActual.terminarCiclo();
    }

    public void convalidar() {
        estadoActual.convalidar();
    }

    public void reprobar() {
        estadoActual.reprobar();
    }

    // Métodos getter
    public Estado getEstadoActual() {
        return estadoActual;
    }
}
```
