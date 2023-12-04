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
