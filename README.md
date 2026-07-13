# Platform Lab

Laboratorio local para practicar herramientas y conceptos de ingeniería de plataforma.

## Tecnologías

- Docker Desktop
- WSL 2
- Kubernetes
- kind
- kubectl
- Ansible
- Argo CD
- Terraform
- Prometheus
- Grafana
- Loki
- OpenTelemetry

## Estado actual

- Docker Desktop instalado.
- WSL 2 con Ubuntu instalado.
- Clúster Kubernetes local creado con kind.
- Ansible instalado en entorno virtual.
- Aplicación Nginx desplegada con manifiestos YAML.
- ConfigMap utilizado para contenido HTML.
- Secret utilizado para variables de demostración.
- Requests y limits configurados.
- Readiness y liveness probes configuradas.
- Service ClusterIP configurado.

## Desplegar la aplicación

```powershell
kubectl apply -f .\kubernetes\

## Seguridad y RBAC

- ServiceAccount propia para Nginx.
- Token de Kubernetes deshabilitado para el contenedor Nginx.
- ServiceAccount de solo lectura para pruebas.
- Role limitado al namespace platform-lab.
- RoleBinding para asignar permisos.
- Validación de permisos mediante kubectl auth can-i.
- Acceso a Secrets, eliminación y creación de recursos denegados.

### Validar permisos permitidos

```powershell
kubectl auth can-i list pods `
  -n platform-lab `
  --as system:serviceaccount:platform-lab:platform-reader

## Aplicación Java Spring Boot

La aplicación Java se despliega en Kubernetes con dos réplicas.

### Componentes

- ConfigMap para configuración no sensible.
- Secret de demostración para la propiedad `mensaje`.
- ServiceAccount propia sin token automático.
- Deployment con estrategia RollingUpdate.
- Requests y limits.
- Startup, readiness y liveness probes.
- Service ClusterIP.
- Imagen Docker local cargada en kind.

### Desplegar

```powershell
kind load docker-image platform-lab-java:1.0.0 --name desktop
kubectl apply -f .\kubernetes\java-app\