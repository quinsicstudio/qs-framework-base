package com.quinsicstudio.framework.base.response;

public interface SystemResponse {
     Response SYS0000 = new Response("SYS0000", "SUCCESS");
     Response SYS9999 = new Response("SYS9999", "FAIL");
     Response SQL9901 = new Response("SQL9901", "SQL error");
     Response REQ9999 = new Response("REQ9999", "Invalid request url or http method type.");
}