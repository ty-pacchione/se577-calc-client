# Calculator Application

Client-side project for SE577 individual assignment 3. The companion server-side project can be found at [ty-pacchione/se577-calc-server](https://github.com/ty-pacchione/se577-calc-server).

## Execute

To run the application, execute `./run.sh` from the root directory (will only work on MacOS). If you would like the server to store your computation history, first start the server-side application in a separate thread. A message will be printed to the console indicating whether the client was successfully connected to the server.

## Implementation Decisions

* The calculator interface does not display error messages; the state of the system remains unchanged when invalid input is entered.

* Only positive integers can be entered as numerical inputs to calculations. Computation results are displayed and recorded to 5 decimal places.

### Required Design Features

* Composite Pattern: Used to construct binary trees representing mathematical expressions. Relevant classes can be found in `src/comp/`.

* Visitor Pattern: Used to traverse expression trees. Relevant classes can be found in `src/engine/` (and `src/comp/`).

* Observer Pattern: Used to update several different components of relevant changes to the system. Interfaces can be found in `src/obsrv/` and message routing is delineated in `src/main/Main.java`.

* State Pattern: Used to determine button input behavior based on the state of the current calculation on the display panel. Relevant classes can be found in `src/state/`.

* Client/Server Architecture - Implemented in `src/client/CalculatorClient.java` in this project and in `src/server/CalculatorServer.java` in the server-side project.