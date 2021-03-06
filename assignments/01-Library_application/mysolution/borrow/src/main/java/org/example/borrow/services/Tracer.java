package org.example.borrow.services;

import brave.Span;
import brave.Tracer;
import org.springframework.stereotype.Service;

@Service
public class Tracer {
    Tracer tracer;

    public Tracer (Tracer tracer) {
        this.tracer = tracer;
    }

    public String getTraceId() {
        Span span = tracer.currentSpan();
        String traceId = span.context().traceIdString();
        return traceId;
    }
}