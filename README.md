# Parking Lot System (Java)

A simple, production-style Parking Lot system demonstrating SOLID principles and the Strategy pattern for spot allocation. The project keeps all Java sources in the repository root (no packages), per requirement.

## Features

- Vehicle types: `BIKE`, `CAR`, `LARGE_VH`
- Abstract `ParkingSpot` with concrete spots: `BikeSpot`, `CarSpot`, `LargeVehicleSpot`
- Fluent service configuration on spots: `spot.addService(new Charging())`
- Services: `Charging` (per-minute), `Cleaning` (per-minute)
- Ticket lifecycle via `EntryGate` (issue) and `ExitGate` (payment)
- Allocation via `AllocateStrategy` (selects first suitable free spot)
- Central ticket store: `TicketMap`

## Project Structure (root folder)

- Core: `ParkingLot`, `Vehicle`, `VehicleType`, `Service`
- Spots: `ParkingSpot`, `BikeSpot`, `CarSpot`, `LargeVehicleSpot`
- Services: `Charging`, `Cleaning`
- Gates & Strategy: `EntryGate`, `ExitGate`, `AllocateStrategy`
- Tickets: `Ticket`, `TicketMap`

## Build & Run

Requires JDK 8+.

```bash
# from project root
javac *.java
java ParkingLot
```

The app runs an interactive loop:

- Enter vehicle type: `BIKE`, `CAR`, or `LARGE`
- Optionally add services (currently supports `ELECTRIC` → Charging)
- A ticket is generated; after a short simulated duration, payment is processed
- Enter `WQ` to quit

## Design Overview

- Abstraction: `ParkingSpot` is an abstract base with shared behavior (ID, type, occupancy, services)
- Specialization: `BikeSpot`, `CarSpot`, `LargeVehicleSpot` provide pricing via `getPricePerMinute()`
- Services: Implement `Service` with `getPriceRate()`; e.g., `Charging`, `Cleaning`
- Allocation: `AllocateStrategy.allocateSpot(vehicle, spots)` chooses a suitable free spot for the vehicle type
- Gating: `EntryGate` issues a `Ticket`; `ExitGate` computes fees and frees the spot
- Ticketing: `Ticket` captures spot and start time; `TicketMap` is a central store keyed by vehicle ID

## Pricing Model

- Spot base price per minute defined by spot type
- Service add-ons per minute via `ParkingSpot.addService(Service)`
- Exit billing uses simulated elapsed time (seconds for easy testing)
