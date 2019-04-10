

toxiproxy-cli toxic add chaoscamp-hasher -t latency -a latency=6000 -a jitter=3000

toxiproxy-cli list
toxiproxy-cli inspect chaoscamp-hasher
toxiproxy-cli toxic remove --toxicName latency_downstream chaoscamp-hasher