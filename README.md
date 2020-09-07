[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](code_of_conduct.md)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)  
![publish docker images](https://github.com/tolstoyfafa/assos_suite/workflows/publish%20backend%20&%20frontend%20docker%20images/badge.svg)  
![Backend CI](https://github.com/tolstoyfafa/assos_suite/workflows/BackendCI/badge.svg)  
# AssosSuite

AssoSuite is a complete free, open source solution to manage assosiations.
### Main features:

* Manage personal / adherents
* Reports /  Statistics
* Manage fundraising 
* Automtised mailling service
* Manage events

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

- clone the project
- node v12.18.3 
- yarn v1.2.5
- Openjdk 11
- maven v3.6

### Installing

#### without Docker
Assosuite contains 2 components `backend` and `frontend`

To get a development env running you should follow each component documentation.
- [backend](backend/README.md)
- [frontend](frontend/README.md)

#### Using Docker
If you want to use Docker to get a developpement env:

- in assosuite root directory run 
```bash
docker-compose up -d
```
You'll have 4 running containers:
 	- backend
	- frontend
	- mongo
	- mail

## Deployment
### Docker compose deployment
- install docker & docker-compose on your machine
- copy the .env-sample, docker-compose-prod.yml to you deployment environment
- rename .env-sample to .env and docker-compose-prod.yml to docker-compose.yml
- mail server configuration: 
you can follow this documentation to use Gmail SMTP 
https://support.cloudways.com/configure-gmail-smtp/
- set your local settings in the .env (read the comments on the file)

- execute this command:
```bash
docker-compose up -d 
```
## Contributing
Please read [CONTRIBUTING.md](CONTRIBUTING.md)

## Versioning

Git

## Authors

* **BORDJAH Fayçal** - *Initial work* - [fayçal Bordjah](https://github.com/tolstoyfafa)

See also the list of [contributors](https://github.com/tolstoyfafa/assos_suite/graphs/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
