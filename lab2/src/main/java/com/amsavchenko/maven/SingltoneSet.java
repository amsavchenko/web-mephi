package com.amsavchenko.maven;

import java.util.HashSet;
import java.util.Set;

// всё взято с хабра
public class SingltoneSet {

    private Set<String> setId;

    private SingltoneSet() {
        setId = new HashSet<String>();
    }

    private static class SingltoneSetHolder {
        private final static SingltoneSet instance = new SingltoneSet();
    }

    public static SingltoneSet getInstance () {
        return SingltoneSetHolder.instance;
    }

    public void addSessionId (String sessionId) {
        setId.add(sessionId);
    }

    public boolean containsSessionId (String sessionId) {
        return setId.contains(sessionId);
    }
}
