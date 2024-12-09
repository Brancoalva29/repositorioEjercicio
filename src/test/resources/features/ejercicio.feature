Feature: Automatización de uso de Facebook desde los navegadores Chrome o Edge

  Background: Se automatizara el uso de facebook ingresando las credenciales de un usuario
    @Ejercicio1
    Scenario Outline: Se validara el ingreso de credenciales incorrectas
      Given como usuario quiero ingresar a facebook
      When ingreso mi usuario <usuario> , password <password>
      And hago clic en Iniciar Sesion
      Then se muestra el login incorrecto

      Examples:
        | usuario               | password           |
        | frescokirby@gmail.com | PasswordIncorrecto |

  @Ejercicio2
    Scenario Outline: Se validara el ingreso de credenciales correctas, ademas se elegira una notificacion para darle 'Me gusta'
      Given como usuario quiero ingresar a facebook
      When ingreso mi usuario <usuario> , password <password>
      And hago clic en Iniciar Sesion
      And se muestra el home
      And se hace clic en Notificaciones
      And se hace scroll a las notifaciones y se elige una notificacion
      And se verifica que se haya cargado correctamente la notificacion
      And se le da clic en Me gusta
      Then se verifica que el post haya recibido el Me gusta
      Examples:
        | usuario                 | password             |
        | frescokirby31@gmail.com | FrescoKirby31.Test$$ |

