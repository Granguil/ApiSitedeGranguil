package granguil.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import granguil.data.Enum.TypeRole;
import granguil.data.entity.AssociatedCode;
import granguil.data.entity.Code;
import granguil.data.entity.Event;
import granguil.data.entity.ExplorerConfiguration;
import granguil.data.entity.Idea;
import granguil.data.entity.KeyWord;
import granguil.data.entity.Navigation;
import granguil.data.entity.Resource;
import granguil.data.entity.Role;
import granguil.data.entity.Secret;
import granguil.data.entity.User;
import granguil.data.entity.Version;
import granguil.data.entity.Module;
import granguil.data.entity.Module.ModuleStatus;
import granguil.data.entity.ModuleType;
import granguil.data.repository.AssociatedCodeRepository;
import granguil.data.repository.CodeRepository;
import granguil.data.repository.ExplorerConfigurationRepository;
import granguil.data.repository.ModuleTypeRepository;
import granguil.data.repository.NavigationRepository;
import granguil.data.repository.ResourceRepository;
import granguil.data.repository.RoleRepository;
import granguil.data.repository.SecretRepository;
import granguil.data.repository.UserRepository;

@SpringBootApplication
public class GranguilDataApplication {

	@Value("${spring.profiles.active}")
	private String environment;
	
	@Value("${test.prod}")
	private String prodMessage;
	
	public static void main(String[] args) {
		SpringApplication.run(GranguilDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ExplorerConfigurationRepository ecr,ModuleTypeRepository moduleRepository,UserRepository userRepository, RoleRepository roleRepository, CodeRepository codeRepository,AssociatedCodeRepository ACR,SecretRepository secretRepository, NavigationRepository navigationRepository, ResourceRepository resourceRepository) {
	return (args)->{
		if(environment.equals("dev")) {
		secretRepository.save(new Secret("Qui est le plus fort","Granguil"));
		secretRepository.save(new Secret("Test1","Granguil"));
		secretRepository.save(new Secret("Test2","Granguil"));
		
		resourceRepository.save(new Resource("Fra","title", "General","Site de Granguil","none"));
		resourceRepository.save(new Resource("Ang","title", "General","Granguil's Site","none"));
		resourceRepository.save(new Resource("Fra","Welcome", "General","Bienvenue","none"));
		resourceRepository.save(new Resource("Ang","Welcome", "General","Welcome","none"));
		resourceRepository.save(new Resource("Fra","UserHome", "ReadAndWrite","Sur ce site, vous pourrez lire les textes déposés ici.","none"));
		resourceRepository.save(new Resource("Ang","UserHome", "ReadAndWrite","On this site, you could read the texts that record here","none"));
		resourceRepository.save(new Resource("Fra","AdminHome", "ReadAndWrite","Sur ce site, vous pouvez importer, exporter vos textes ainsi que les modifier et configurer comment ils seront afficher.","none"));
		resourceRepository.save(new Resource("Ang","AdminHome", "ReadAndWrite","On this site, you could import, export your texts and also modify them and configure how it's display.","none"));
		resourceRepository.save(new Resource("Fra","subtitle", "General","New Project","none"));
		resourceRepository.save(new Resource("Fra","subtitle", "GestiondeProjet","gestion de projet","none"));
		resourceRepository.save(new Resource("Ang","subtitle", "GestiondeProjet","Project Management","none"));
		resourceRepository.save(new Resource("Fra","subtitle", "ReadAndWrite","Univers de Granguil","none"));
		resourceRepository.save(new Resource("Ang","subtitle", "ReadAndWrite","Granguil's Universe","none"));
		resourceRepository.save(new Resource("Fra","connected", "General","Se Connecter","none"));
		resourceRepository.save(new Resource("Fra","slash","General", "/","none"));
		resourceRepository.save(new Resource("Fra","subscribe","General", "S'Inscrire","none"));
		resourceRepository.save(new Resource("Fra","contactTitle","General", "Contact","none"));
		resourceRepository.save(new Resource("Fra","contactLink", "General","www.sitedegranguil.fr","none"));
		resourceRepository.save(new Resource("Fra","contactMail", "General","guillaume.curabet@gmail.com","none"));
		resourceRepository.save(new Resource("Fra","Reading", "ReadAndWrite","Lecture","nav"));
		resourceRepository.save(new Resource("Fra","Home", "ReadAndWrite","Accueil","nav"));
		resourceRepository.save(new Resource("Ang","Reading", "ReadAndWrite","Reading","nav"));
		resourceRepository.save(new Resource("Ang","Writing", "ReadAndWrite","Writing","nav"));
		resourceRepository.save(new Resource("Fra","Writing", "ReadAndWrite","Ecriture","nav"));
		resourceRepository.save(new Resource("Fra","Import", "ReadAndWrite","Import","nav"));
		resourceRepository.save(new Resource("Ang","Home", "ReadAndWrite","Home","nav"));
		resourceRepository.save(new Resource("Fra","User", "ReadAndWrite","Utilisateur","nav"));
		resourceRepository.save(new Resource("Fra","ReadAndWrite", "ReadAndWrite","Lecture et Ecriture","nav"));
		resourceRepository.save(new Resource("Ang","ReadAndWrite", "ReadAndWrite","Reading and Writing","nav"));
		resourceRepository.save(new Resource("Ang","User", "ReadAndWrite","User","nav"));
		resourceRepository.save(new Resource("Fra","Favorites", "ReadAndWrite","Favoris","nav"));
		resourceRepository.save(new Resource("Ang","Favorites", "ReadAndWrite","Favorites","nav"));
		resourceRepository.save(new Resource("Ang","Bookmark", "ReadAndWrite","Bookmarks","explorer"));
		resourceRepository.save(new Resource("Fra","Bookmark", "ReadAndWrite","Marque-Pages","explorer"));
		resourceRepository.save(new Resource("Fra","TitleCard0", "ReadAndWrite","Univers","explorer"));
		resourceRepository.save(new Resource("Fra","TitleCard1", "ReadAndWrite","Livres","explorer"));
		resourceRepository.save(new Resource("Fra","TitleCard2", "ReadAndWrite","Chapitres","explorer"));
		resourceRepository.save(new Resource("Fra","TitleCard3", "ReadAndWrite","Scènes","explorer"));
		resourceRepository.save(new Resource("Ang","TitleCard0", "ReadAndWrite","Universe","explorer"));
		resourceRepository.save(new Resource("Ang","TitleCard1", "ReadAndWrite","Books","explorer"));
		resourceRepository.save(new Resource("Ang","TitleCard2", "ReadAndWrite","Chapters","explorer"));
		resourceRepository.save(new Resource("Ang","TitleCard3", "ReadAndWrite","Scenes","explorer"));
		resourceRepository.save(new Resource("Ang","TitleCard4", "ReadAndWrite","Blocks","explorer"));
		resourceRepository.save(new Resource("Ang","createBookMark", "ReadAndWrite","N.B. :To create Bookmark, click on the button under the choosen scene.","explorer"));
		resourceRepository.save(new Resource("Fra","createBookMark", "ReadAndWrite","N.B. :Pour créer un marque-page, cliquer sur le bouton en-dessous de la scène choisie.","explorer"));
		
		ecr.save(new ExplorerConfiguration("explorer",true,true,4,true,true));
		
		navigationRepository.save(new Navigation("Groupe1","Granguil",null,UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"GestiondeProjet"));
		navigationRepository.save(new Navigation("Groupe1","Lisi","New",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"GestiondeProjet"));
		navigationRepository.save(new Navigation("Groupe2","Eileen","New",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"GestiondeProjet"));
		navigationRepository.save(new Navigation("Home","Home","Accueil/Admin",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"ReadAndWrite"));
		navigationRepository.save(new Navigation("ReadAndWrite","Writing","Accueil/Action",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"ReadAndWrite"));
		navigationRepository.save(new Navigation("ReadAndWrite","Import","Accueil/Action",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"ReadAndWrite"));
		navigationRepository.save(new Navigation("ReadAndWrite","Reading","Accueil/Action",UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"),"ReadAndWrite"));
		navigationRepository.save(new Navigation("Home","Home","Accueil/User",UUID.fromString("8a83b37a-60a9-4278-ba7e-37667b55f596"),"ReadAndWrite"));
		navigationRepository.save(new Navigation("ReadAndWrite","Reading","Accueil/Action",UUID.fromString("8a83b37a-60a9-4278-ba7e-37667b55f596"),"ReadAndWrite"));
		//navigationRepository.save(new Navigation("ReadAndWrite","Favorites","Accueil/Action",UUID.fromString("8a83b37a-60a9-4278-ba7e-37667b55f596"),"ReadAndWrite"));
		
		
		
		Code code=new Code();
		code.setTableName("Test");
		Event event=new Event();
		event.setNom("TestEvent");
		event.setCode(code);
		Idea idea=new Idea();
		idea.setNom("TestIdea");
		idea.setCode(code);
		code.setEvent(event);
		code.setIdea(idea);
		KeyWord kw1=new KeyWord();
		KeyWord kw2=new KeyWord();
		kw1.setKeyWord("Granguil");
		kw2.setKeyWord("Lisi");
		List<KeyWord> LKW=new ArrayList<KeyWord>();
		LKW.add(kw1);
		LKW.add(kw2);
		AssociatedCode AC=new AssociatedCode();
		AC.setKeyWords(LKW);
		kw1.setCode(AC);
		kw2.setCode(AC);
		AC.setCode(code);
		code.setAssociatedElement(AC);
		codeRepository.save(code);
		
		Role role=new Role();
		role.setCode(UUID.fromString("8a83b37a-60a9-4278-ba7e-37667b55f596"));
		role.setName("User");
		role.setTypeRole(TypeRole.USER);
		role=roleRepository.save(role);
		Role managerRole=new Role();
		managerRole.setName("Chef de Projet");
		managerRole.setTypeRole(TypeRole.MANAGER);
		managerRole.setCode(UUID.fromString("65d6375a-69de-4e15-ba96-107ffd451b3a"));
		managerRole=roleRepository.save(managerRole);
		try {
		User user=new User();
		user.setIsTester(false);
		user.setMd("eds56s");
		user.setPseudo("gui");
		user.setRole(role);
		user.setToken1("Token2");
		user.setLanguage("Fra");
		user.setUrlHome("/Accueil/User/Home");
		userRepository.save(user);
		}catch(Exception e) {
			System.out.println("User : "+e.getMessage());
		}
		try {
		User manager=new User();
		manager.setIsTester(true);
		manager.setPseudo("Granguil");
		manager.setMd("efo2dbpFs6ca");
		manager.setRole(managerRole);
		manager.setToken1("Token1");
		manager.setLanguage("Fra");
		manager.setUrlHome("/Accueil/Admin/Home");
		userRepository.save(manager);
		}catch(Exception e) {
			System.out.println("Manager : "+e.getMessage());
		}
		
		Version vp1=new Version(0,"Patch","beta","First Test",null,ModuleStatus.ARCHIVED);
		Version vp2=new Version(1,"Patch","alpha","First Test",null,ModuleStatus.ACTIVE);
		Version vp3=new Version(2,"Patch","new","First Test",null,ModuleStatus.USED);
		List<Version> vp=new ArrayList<Version>();
		vp.add(vp1);
		vp.add(vp2);
		vp.add(vp3);
		Version mi=new Version(0,"Minor","test","Beta",vp,ModuleStatus.ACTIVE);
		vp1.setVersion_parent(mi);
		vp2.setVersion_parent(mi);
		vp3.setVersion_parent(mi);
		List<Version> vmi=new ArrayList<Version>();
		vmi.add(mi);
		Version ma=new Version(1,"Major","First Version","First Test",vmi,ModuleStatus.ACTIVE);
		mi.setVersion_parent(ma);
		List<Version> vma=new ArrayList<Version>();
		vma.add(ma);
		Module module=new Module("Génération de requête au serveur","fetchelper",vma,ModuleStatus.ACTIVE);
		ma.setModule(module);
		List<Module> modules=new ArrayList<Module>();
		modules.add(module);
		ModuleType mt=new ModuleType("Javascript","Animation d'une page Web",modules);
		module.setType(mt);
		moduleRepository.save(mt);
		}else {
			System.out.println("Profil : "+environment);
			System.out.println("Database not seeded");
			System.out.println(prodMessage);
		}
	};
	
	}
}
