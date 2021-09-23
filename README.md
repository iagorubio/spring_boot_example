[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO
<br />
<p align="center">

  <a href="https://github.com/iagorubio/springboot-example">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">springboot example</h3>

  <p align="center">
    Simple springboot example
    <br />
    <a href="https://github.com/iagorubio/springboot-example"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/iagorubio/springboot-example">View Demo</a>
    ·
    <a href="https://github.com/iagorubio/springboot-example/issues">Report Bug</a>
    ·
    <a href="https://github.com/iagorubio/springboot-example/issues">Request Feature</a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
<!--
    <li><a href="#acknowledgements">Acknowledgements</a></li>
-->
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This is a simple example of a complete springboot application,

It contains examples of:
* [Spring Security](https://spring.io/projects/spring-security): including USER and ADMIN roles and filters for them.
* [JPA](https://spring.io/projects/spring-data-jpa) configuration to be used with the security adapter.
* A really simple [Rest Controller](https://en.wikipedia.org/wiki/Representational_state_transfer)
* A custom [error controller](https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc).
* [Thymeleaf](https://www.thymeleaf.org/) templates - really simple no template resolver.
* Unit tests and Mocks for everything.

### Built With

* [Spring](https://spring.io/)
* [IntelliJIDEA](https://www.jetbrains.com/idea/)
* [OpenJDK](https://openjdk.java.net/)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

You need a working Java runtime and JDK. This project has been built with [OpenJDK 14](https://openjdk.java.net/projects/jdk/14/).

You can use another JDK, but you may need to tweak the sources - most likely remove lambdas if using a JDK < 8.

I recommend using a Java IDE such as [IntelljIDEA Community](https://www.jetbrains.com/idea/), [Eclipse](https://www.eclipse.org/community/eclipse_newsletter/2018/february/springboot.php) or [VSCode](https://code.visualstudio.com/) with [Spring Tools 4](https://spring.io/tools) plugin  

You need a working MySQL.

To create the required database use the following script:

   ```sql
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                        `username` varchar(50) NOT NULL,
                        `password` text,
                        `enabled` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('adm','pwd123','true'),('user','pwd123','true');
UNLOCK TABLES;

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
                              `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                              `username` varchar(50) DEFAULT NULL,
                              `authority` varchar(50) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `authorities` WRITE;
INSERT INTO `authorities` VALUES (1,'user','ROLE_USER'),(2,'adm','ROLE_ADMIN');
UNLOCK TABLES;
   ```
The script is also located at the project root directory.

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/iagorubio/springboot-example.git
   ```
2. Run maven for your IDE or command line
   ```sh
   JAVA_HOME=/path/to/java14 mvn clean install
   ```
   
If no errors are shown, everything is ready to run.

   ```sh
   JAVA_HOME=/path/to/java14 mvn exec:java -Dexec.mainClass="com.iagorubio.ioweb.IowebApplication" -Dlogging.level.org.springframework=TRACE  
   ```
Then point your browser to http://localhost:8080/

<!-- USAGE EXAMPLES -->
## Usage

Once you opened the project in your browser you would be able to view the index
page with a link to public part and another to the admin part.

Those are two simple one-liner pages.

To be able to view the admin page you must log in as *adm* with password *pwd123*.

To be able to view the public page you must log as *user* with password *pwd123*.

You can visit http://localhost:8080/logout to log out.

<!-- ROADMAP -->
## Roadmap

This is a simple example to help you explore spring and spring security.

It won't be updated further but for fix requests.

You can request an update on the project's issues.

See the [open issues](https://github.com/iagorubio/springboot-example/issues) for a list of proposed features (and known issues).
LPO

<!-- CONTRIBUTING -->
## Contributing

If you find a problem, bug or enhancement please send me a PR.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.

<!-- CONTACT -->
## Contact

Yago Rubio Sanfiz - [@YagoRubioSanfiz](https://twitter.com/YagoRubioSanfiz/) - iago AT iagorubio.com

Project Link: [https://github.com/iagorubio/springboot-example](https://github.com/iagorubio/springboot-example)

<!-- ACKNOWLEDGEMENTS
## Acknowledgements

* []()
* []()
* []()
 -->




<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/iagorubio/repo.svg?style=for-the-badge
[contributors-url]: https://github.com/iagorubio/springboot-example/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/iagorubio/repo.svg?style=for-the-badge
[forks-url]: https://github.com/iagorubio/springboot-example/network/members
[stars-shield]: https://img.shields.io/github/stars/iagorubio/repo.svg?style=for-the-badge
[stars-url]: https://github.com/iagorubio/springboot-example/stargazers
[issues-shield]: https://img.shields.io/github/issues/iagorubio/repo.svg?style=for-the-badge
[issues-url]: https://github.com/iagorubio/springboot-example/issues
[license-shield]: https://img.shields.io/github/license/iagorubio/repo.svg?style=for-the-badge
[license-url]: https://github.com/iagorubio/springboot-example/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/iago-rubio
