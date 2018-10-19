package com.example.apple.mindsharpner.data.local.entity

import com.google.gson.JsonDeserializer

abstract class BaseEntity<T> : JsonDeserializer<T>