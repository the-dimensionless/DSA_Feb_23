package basic.design_patterns;

public sealed interface TrafficLight {
}

final class RedLight implements TrafficLight {}

final class GreenLight implements TrafficLight {}
