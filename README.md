# java-networking
java networking


###### 
A TCP port is just a number... a 16-bit number that identifies a specific program on the server

#####
Each Client has to know about the Server.

#####
The Server has to know about ALL the Clients.

#####
 Establishing a connection is a one-time operation (that either works or fails).

 #####
 To make a connection, you need to know two things about the server: where it is and which port it’s running on.
 IP address and TCP port number.

#####
 Your internet web (HTTP) server runs on port 80

 #####
 Think of port numbers as unique identifiers. They represent a logical connection to a particular piece of software running on the server. That’s it.

 #####
 | protocol | port number|
|------------------|------------------|
|HTTP    | 80   |
| HTTPS   | 443   |
| POP3    | 110    |
| FTP   | 20    |
|Telnet    | 23  |
| SMTP     |25 |
| Time     | 37 |

#####
Without port numbers, the server would have no way of knowing which application a client wanted to connect to

#####
0 tto 1023 are reserved for the well-known services like the ones we just talked about.

#####
The java.net.Socket class is available in all versions of Java.

#####
Channels are in the java.nio.channels package

#####
Channels support advanced networking features
Channels can support nonblocking I/O, reading and writing via ByteBuffers, and asynchronous I/O.

#####
What two pieces of information does the client need in order to make a connection with a server?
port and ip address

#####
Client and server applications communicate using Channels.

#####
A Channel represents a connection between two applications that may (or may not) be running on two different physical machines.

####
A client must know the IP address (or host name) and TCP port number of the server application.

#####
A TCP port is a 16-bit unsigned number assigned to a specific server application. TCP port numbers allow different server applications to run on the same machine; clients connect to a specific application using its port number.

#####
The port numbers from 0 through 1023 are reserved for “well-known services” including HTTP, FTP, SMTP, etc.

#####


