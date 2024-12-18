# Makefile to pull and run Ollama Docker image, and download the tinyllama model

# Docker image and container names
IMAGE_NAME = ollama/ollama
CONTAINER_NAME = ollama

# Port for Ollama service
PORT = 11434

# Default target
all: pull_image run_ollama download_model

# Pull Ollama docker image
pull_image:
	@echo "Pulling Ollama docker image..."
	docker pull $(IMAGE_NAME)

# Run Ollama container as a background process
run_ollama:
	@echo "Running Ollama container on port $(PORT)..."
	docker run -d -v ollama:/root/.ollama -p $(PORT):$(PORT) --name $(CONTAINER_NAME) $(IMAGE_NAME)

# Download and run the tinyllama model
download_model:
	@echo "Running tinyllama model..."
	docker exec -it $(CONTAINER_NAME) ollama run tinyllama

# Clean up and remove the container
clean:
	@echo "Stopping and removing the Ollama container..."
	docker stop $(CONTAINER_NAME)
	docker rm $(CONTAINER_NAME)