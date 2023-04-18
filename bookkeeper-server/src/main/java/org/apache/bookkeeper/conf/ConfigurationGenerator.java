package org.apache.bookkeeper.conf;

import edu.illinois.confuzz.internal.ConfuzzGenerator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigurationGenerator extends Generator<Map> {
    public static final Logger LOG = LoggerFactory.getLogger(ConfigurationGenerator.class);
    private static Map<String, Object> generatedConf = null;
    private static String setMethodName = "put";
    private static Class<?>[] setParameterTypes = {String.class, Object.class};
    /**
     * Constructor for Configuration Generator
     */
    public ConfigurationGenerator() throws IOException {
        super(Map.class);
    }

    public static Map<String, Object> getGeneratedConfig() {
        if (generatedConf == null) {
            return null;
        }
        return Collections.unmodifiableMap(generatedConf);
    }

    /**
     * This method is invoked to generate a Configuration object
     * @param random
     * @param generationStatus
     * @return
     */
    @Override
    public Map<String, Object> generate(SourceOfRandomness random, GenerationStatus generationStatus) {
        generatedConf = new LinkedHashMap<>();
        generatedConf = ConfuzzGenerator.generate(random);
        return generatedConf;
    }

}

