package gloomyfolken.hooklib.minecraft;

import net.minecraft.launchwrapper.LaunchClassLoader;

import cpw.mods.fml.common.Loader;
import gloomyfolken.hooklib.asm.Hook;

public class SecondaryTransformerHook {

    @Hook
    public static void injectData(Loader loader, Object... data) {
        ClassLoader classLoader = SecondaryTransformerHook.class.getClassLoader();
        if (classLoader instanceof LaunchClassLoader) {
            ((LaunchClassLoader) classLoader).registerTransformer(MinecraftClassTransformer.class.getName());
        } else {
            System.out.println("HookLib was not loaded by LaunchClassLoader. Hooks will not be injected.");
        }
    }

}
