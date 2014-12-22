#!/usr/bin/env rdmd

import std.math, std.stdio, std.datetime;

void main() {

	auto t1 = Clock.currTime();

	auto logs = new double[1_000_000_000];

	foreach (i; 0 .. logs.length) {
		logs[i] = log(i + 1.0);
	}

	auto t2 = Clock.currTime();

	writeln("time: ", (t2 - t1));
}
