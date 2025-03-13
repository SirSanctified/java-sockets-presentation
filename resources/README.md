# Socket Programming Examples

This directory contains examples of different distributed computing implementations using Java, including TCP sockets, UDP sockets, and RMI (Remote Method Invocation).

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- A Java IDE or command line tools for compilation

## Directory Structure

```
resources/
├── TCPServer.java     - TCP Socket Server implementation
├── TCPClient.java     - TCP Socket Client implementation
├── UDPServer.java     - UDP Socket Server implementation
├── UDPClient.java     - UDP Socket Client implementation
└── RMIExample.java    - Complete RMI implementation
```

## Running the Examples

### TCP Socket Example

1. First, compile both files:
   ```bash
   javac TCPServer.java TCPClient.java
   ```

2. Open two terminal windows

3. In the first terminal, start the server:
   ```bash
   java TCPServer
   ```

4. In the second terminal, start the client:
   ```bash
   java TCPClient
   ```

5. Type messages in the client terminal. Type 'exit' to quit.

### UDP Socket Example

1. First, compile both files:
   ```bash
   javac UDPServer.java UDPClient.java
   ```

2. Open two terminal windows

3. In the first terminal, start the server:
   ```bash
   java UDPServer
   ```

4. In the second terminal, start the client:
   ```bash
   java UDPClient
   ```

5. Type messages in the client terminal. Type 'exit' to quit.

### RMI Example

1. Compile the RMI example:
   ```bash
   javac RMIExample.java
   ```

2. Run the example:
   ```bash
   java RMIExample
   ```

   This will automatically:
   - Start the RMI registry
   - Start the RMI server
   - Run the client
   - Display the result of adding two numbers

## Port Numbers

- TCP Server: 8080
- UDP Server: 9090
- RMI Registry: 1099

## Example Usage

### TCP/UDP Client
```
Connected to server. Type messages:
Hello
Server response: Server received: Hello
World
Server response: Server received: World
exit
```

### RMI Example
```
RMI Server is running
5 + 3 = 8
```

## Notes

- All examples use 'localhost' as the server address
- The servers will continue running until manually terminated
- Clients can be stopped by typing 'exit'
- Error handling is implemented for all network operations
- Each example demonstrates different aspects of distributed computing:
  - TCP: Connection-oriented, reliable communication
  - UDP: Connectionless, faster but unreliable communication
  - RMI: High-level, method-based distributed computing