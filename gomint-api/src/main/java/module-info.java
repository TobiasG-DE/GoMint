open module gomint.api {
    requires com.google.common;
    requires it.unimi.dsi.fastutil;
    requires java.desktop;
    requires json.simple;
    requires org.yaml.snakeyaml;
    requires org.slf4j;
    requires commons.math3;

    exports io.gomint;
    exports io.gomint.command;
    exports io.gomint.command.annotation;
    exports io.gomint.command.validator;
    exports io.gomint.config;
    exports io.gomint.config.annotation;
    exports io.gomint.config.converter;
    exports io.gomint.crafting;
    exports io.gomint.enchant;
    exports io.gomint.entity;
    exports io.gomint.entity.active;
    exports io.gomint.entity.monster;
    exports io.gomint.entity.passive;
    exports io.gomint.entity.potion;
    exports io.gomint.entity.projectile;
    exports io.gomint.event;
    exports io.gomint.event.entity;
    exports io.gomint.event.entity.projectile;
    exports io.gomint.event.inventory;
    exports io.gomint.event.network;
    exports io.gomint.event.player;
    exports io.gomint.event.plugin;
    exports io.gomint.event.world;
    exports io.gomint.gui;
    exports io.gomint.gui.element;
    exports io.gomint.i18n;
    exports io.gomint.i18n.localization;
    exports io.gomint.i18n.localization.loader;
    exports io.gomint.inventory;
    exports io.gomint.inventory.item;
    exports io.gomint.inventory.item.data;
    exports io.gomint.inventory.transaction;
    exports io.gomint.math;
    exports io.gomint.permission;
    exports io.gomint.player;
    exports io.gomint.plugin;
    exports io.gomint.plugin.injection;
    exports io.gomint.scheduler;
    exports io.gomint.scoreboard;
    exports io.gomint.util;
    exports io.gomint.util.random;
    exports io.gomint.world;
    exports io.gomint.world.block;
    exports io.gomint.world.block.data;
    exports io.gomint.world.block.data.banner;
    exports io.gomint.world.generator;
    exports io.gomint.world.generator.biome;
    exports io.gomint.world.generator.integrated;
    exports io.gomint.world.generator.noise;
    exports io.gomint.world.generator.object;
    exports io.gomint.world.generator.populator;
    exports io.gomint.world.biome;
    exports io.gomint.world.biome.component;
    exports io.gomint.entity.animal;
    exports io.gomint.event.enchant;
}
