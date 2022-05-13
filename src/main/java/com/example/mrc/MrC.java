package com.example.mrc;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.mrc.setup.ClientSetup;
import com.example.mrc.setup.ModSetup;
import com.example.mrc.setup.Registration;

@Mod(MrC.MODID) 
public class MrC{

	private static final Logger LOGGER = LogManager.getLogger(); 
	public static final String MODID = "mrc";

	public MrC() {
		// Register the deferred registry 
		Registration.init();
		
		// Register the setup method for modLoading 
		IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus(); 
		modbus.addListener(ModSetup::init);
		DistExecutor.unsafeRunWhenOn (Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
	}
}




















// The value here should match an entry in the META-INF/mods.toml file
//@Mod("examplemod")
//public class ExampleMod
//{
//    public static final String MODID ="mrc"; 
//    public static final String NAME ="Mr.C Test";
//    public static final String VERSION ="0.0.1";  
//    
//    
//    // Directly reference a log4j logger.
//    private static final Logger LOGGER = LogManager.getLogger();
//    
//    public static ArmorMaterial myArmorMaterial;
//    public static Item myHelmet;
//  
//  
//    public ExampleMod() {
//        // Register the setup method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
//
//        // Register ourselves for server and other game events we are interested in
//        MinecraftForge.EVENT_BUS.register(this);
//    }
//
//    private void setup(final FMLCommonSetupEvent event)
//    {
//        // some preinit code
//        LOGGER.info("HELLO FROM PREINIT");
//        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
//    }
//
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.messageSupplier().get()).
//                collect(Collectors.toList()));
//    }
//    // You can use SubscribeEvent and let the Event Bus discover methods to call
//    @SubscribeEvent
//    public void onServerStarting(ServerStartingEvent event) {
//        // do something when the server starts
//        LOGGER.info("HELLO from server starting");
//    }
//
//    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
//    // Event bus for receiving Registry Events)
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
//}
