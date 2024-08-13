## Frameworks Orientados a Objetos

- Un framework es una aplicación "semicompleta", "reusable", que puede ser especializada para producir aplicaciones a medida...
- _...un conjunto de clases concretas y abstractas, relacionadas (que trabajan juntas) para proveer una arquitectura reusable para una familia de aplicaciones relacionadas..._
- Los desarrolladores incorporan el framework en sus aplicaciones y lo especializan para cubrir sus necesidades.
- _...el framework define el esqueleto, y el desarrollador define sus propias características para completar el esqueleto..._
- _(a diferencia de un toolkit o librería) un framework provee una estructura coherente en lugar de un conjunto de "clases útiles"_
- Proveer una solución reusable para una familia de aplicaciones/problemas relacionadas.
- Las clases en el framework se relacionan (herencia, conocimiento, envío de mensajes) de manera que resuelvan la mayor parte del problema en cuestión _(conforman un todo)_
- El código del framework controla al nuestro **(Inversion de Control)**.

## Frameworks de Infraestructura
- Estos frameworks ofrecen una infraestructura portable y eficiente sobre la cual contruir una gran variedad de aplicaciones.
- Algunos de los focos de este tipo de frameworks son: interfaces de usuario (desktop, web, moviles), seguiridad, contenedores de aplicación, procesamiento de imágenes, procesamiento de lenguajes, comunicaciónes.
- Atacan problemas generales de desarrollo de software, que por lo general no son percibidos completamente por el usuario de la aplicación (es decir, resuelven problemas de los programadores, no de los usuarios).
- Es común que se los incluya como parte de plataformas de desarrollo (Java tiene los suyos, al igual que .NET).

## Frameworks de Integración

- Estos frameworks se utilizan comunmente para integrar componentes de aplicación distribuidos (p.e., la base de datos con la aplicación y ésta con su cliente liviano).

## Frameworks de aplicación (o Enterprise)


## Frozenspot vs Hotspot

#### Frozenspot de un framework
- Todas las aplicaciones construidas con un mismo framework tienen aspectos en común que no podemos cambiar (la parte que es común a todas las aplicaciones creadas con el framework).
#### Hotspot de un framework
- El framework ofrece puntos de extensión que nos permiten introducir variantes y así construir aplicaciones diferentes (los sectores que hacen a cada aplicación construida con determinado framework, diferenciarse una de otras).


## Caja blanca vs Caja Negra
- Los puntos de extensión pueden implemetarse en base a herencia o en base a composición.
- A los frameworks que utilizan herencia en sus puntos de extensión, les llamamos de Caja Blanca (Whitebox)
- A los que utilizan composición se los llama de Caja Negra (Blackbox).
- La mayoría de los frameworks están en algún lugar en el medio.
    - Algunos usuarios los ven como caja negra y otros como blanca.