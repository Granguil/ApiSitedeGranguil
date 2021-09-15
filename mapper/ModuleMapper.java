package granguil.data.mapper;

import java.util.Collections;
import java.util.List;

import granguil.data.entity.Module;
import granguil.data.entity.Module.ModuleStatus;
import granguil.data.entity.ModuleType;
import granguil.data.entity.Version;
import granguil.data.request.ModuleSaveRequest;
import granguil.data.response.ModuleExplorerResponse;
import granguil.data.response.ModuleResponse;
import granguil.data.response.PatchModuleResponse;

public class ModuleMapper {
	public static Version getVersion(ModuleSaveRequest version) {
		Version v=new Version();
		v.setDescription(version.getDescription());
		v.setNumero(version.getNumero());
		v.setTag(version.getTitle());
		v.setVersion_level(version.getType().toString());
		if(version.getId()!=null) {
			v.setId(version.getId());
			v.setStatus(version.getStatus());
		}else {
			v.setStatus(ModuleStatus.ACTIVE);
		}
		return v;
	}
	
	public static Module getModule(ModuleSaveRequest module) {
		Module mod=new Module();
		mod.setDescription(module.getDescription());
		mod.setName(module.getTitle());
		mod.setType_mod(module.getType().toString());
		if(module.getId()!=null) {
			mod.setId(module.getId());
			mod.setStatus(module.getStatus());
			
		}else {
			mod.setStatus(ModuleStatus.ACTIVE);
		}
		return mod;
	}
	
	public static ModuleResponse getModules(List<ModuleType> modules) {
		ModuleResponse module=new ModuleResponse();
		for(ModuleType mod:modules) {
			System.out.println("Type");
			module.Element.add(new ModuleExplorerResponse(mod.getCode(),mod.getType(),mod.getName(),mod.getDescription(),null,null));
			for(Module m:mod.getModule()) {
				System.out.println("Module");
				module.Element.add(new ModuleExplorerResponse(m.getId(),m.getType_mod(),m.getName(),m.getDescription(),mod.getCode(),m.getStatus()));
				Collections.sort(m.getVersions(),(v1,v2)->{return v1.getNumero()-v2.getNumero();});
				for(Version major:m.getVersions()) {
					System.out.println("Major");
					module.Element.add(new ModuleExplorerResponse(major.getId(),major.getVersion_level(),major.getNumero()+" ("+major.getTag()+")",major.getDescription(),m.getId(),major.getStatus()));
					Collections.sort(major.getVersions(),(v1,v2)->{return v1.getNumero()-v2.getNumero();});
					for(Version minor:major.getVersions()) {
						System.out.println("Minor");
						module.Element.add(new ModuleExplorerResponse(minor.getId(),minor.getVersion_level(),minor.getNumero()+" ("+minor.getTag()+")",minor.getDescription(),major.getId(),minor.getStatus()));
						Collections.sort(minor.getVersions(),(v1,v2)->{return v1.getNumero()-v2.getNumero();});
						for(Version patch:minor.getVersions()) {
							System.out.println("Patch");
							module.Bloc.add(new PatchModuleResponse(patch.getId(),patch.getNumero()+" ("+patch.getTag()+")",patch.getDescription(),minor.getId(),patch.getStatus()));
						}
					}
				}
			}
		}
		
		/*ModuleExplorerResponse m1=new ModuleExplorerResponse(UUID.randomUUID(),"Type","React","Framework de JS",null);
		ModuleExplorerResponse m2=new ModuleExplorerResponse(UUID.randomUUID(),"Type","CSS","Mise en Page",null);
		ModuleExplorerResponse m3=new ModuleExplorerResponse(UUID.randomUUID(),"Module","Button","Custom Button",m1.getId());
		ModuleExplorerResponse m4=new ModuleExplorerResponse(UUID.randomUUID(),"Module","Fetch","Fetch Request",m1.getId());
		ModuleExplorerResponse m5=new ModuleExplorerResponse(UUID.randomUUID(),"Module","CSS Genral","Variable CCS",m2.getId());
		ModuleExplorerResponse m6=new ModuleExplorerResponse(UUID.randomUUID(),"Major","1 (Basic Button)","One Button",m3.getId());
		ModuleExplorerResponse m7=new ModuleExplorerResponse(UUID.randomUUID(),"Major","2 (Color Button)","Many Button depends effect",m3.getId());
		ModuleExplorerResponse m8=new ModuleExplorerResponse(UUID.randomUUID(),"Major","1 (Basic Request)","Basic Request",m4.getId());
		ModuleExplorerResponse m9=new ModuleExplorerResponse(UUID.randomUUID(),"Major","1 (Graphic Chart)","Graphic Chart",m5.getId());
		ModuleExplorerResponse m10=new ModuleExplorerResponse(UUID.randomUUID(),"Minor","0 (beta)","Default Variable",m9.getId());
		ModuleExplorerResponse m11=new ModuleExplorerResponse(UUID.randomUUID(),"Minor","0 (Default Color)","Chart Color",m7.getId());
		ModuleExplorerResponse m12=new ModuleExplorerResponse(UUID.randomUUID(),"Minor","0 (WO token)","Basic Request",m8.getId());
		ModuleExplorerResponse m13=new ModuleExplorerResponse(UUID.randomUUID(),"Minor","1 (W token)","Request with Token",m8.getId());
		ModuleExplorerResponse m14=new ModuleExplorerResponse(UUID.randomUUID(),"Minor","0 (beta)","First Test",m6.getId());
		module.Element.add(m1);
		module.Element.add(m2);
		module.Element.add(m3);
		module.Element.add(m4);
		module.Element.add(m5);
		module.Element.add(m6);
		module.Element.add(m7);
		module.Element.add(m8);
		module.Element.add(m9);
		module.Element.add(m10);
		module.Element.add(m11);
		module.Element.add(m12);
		module.Element.add(m13);
		module.Element.add(m14);*/
		
		/*PatchModuleResponse patch1=new PatchModuleResponse("0 (New)","Premiers Tests",m10.getId());
		PatchModuleResponse patch2=new PatchModuleResponse("1 (Test)","Tests d'afficahge",m10.getId());
		PatchModuleResponse patch3=new PatchModuleResponse("2 (Test Validated)","Affichage Validée",m10.getId());
		PatchModuleResponse patch4=new PatchModuleResponse("0 (beta)","Firsts Tests",m14.getId());
		PatchModuleResponse patch5=new PatchModuleResponse("0 (New 5)","5Premiers Tests",m11.getId());
		PatchModuleResponse patch6=new PatchModuleResponse("0 (New 6)","6Premiers Tests",m12.getId());
		PatchModuleResponse patch7=new PatchModuleResponse("0 (New 7)","7Premiers Tests",m13.getId());
		PatchModuleResponse patch8=new PatchModuleResponse("1 (New 8)","8Premiers Tests",m13.getId());
		module.Bloc.add(patch1);
		module.Bloc.add(patch2);
		module.Bloc.add(patch3);
		module.Bloc.add(patch4);
		module.Bloc.add(patch5);
		module.Bloc.add(patch6);
		module.Bloc.add(patch7);
		module.Bloc.add(patch8);*/
		return module;
	}
	
	/*public static List<ModuleType> getModulesToSave(List<ModuleRequest> modules) {
		List<ModuleType> mtl=new ArrayList<ModuleType>();
		Map<UUID,ModuleType> mapMT=new HashMap<UUID,ModuleType>();
		Map<UUID,Module> mapM=new HashMap<UUID,Module>();
		Map<UUID,Version> mapV=new HashMap<UUID,Version>();
		for(ModuleRequest mr:modules) {
			for(ModuleExplorerRequest mer:mr.getElement()) {
				if(mer.getType().equals("Type")) {
					if(mer.getId()!=null) {
						ModuleType mt=new ModuleType();
						mt.setCode(mer.getId());
						mapMT.put(mt.getCode(), mt);
						mtl.add(mt);
					}else {
						
					}
				}else if(mer.getType().equals("Module")) {
					if(mer.getId()!=null) {
						Module mod=new Module();
						mod.setId(mer.getId());
						ModuleType mtp=mapMT.get(mer.getParent());
						mod.setType(mtp);
						mtp.getModule().add(mod);
						mapM.put(mod.getId(), mod);
					}else {
						
					}
				}else if(mer.getType().equals("Major")) {
					if(mer.getId()!=null) {
						Version v=new Version();
						v.setId(mer.getId());
						Module m=mapM.get(mer.getParent());
						v.setModule(m);
						m.getVersions().add(v);
						mapV.put(mer.getId(), v);
					}else {
						
					}
				}else if(mer.getType().equals("Minor")) {
					if(mer.getId()!=null) {
						Version v=new Version();
						v.setId(mer.getId());
						Version vp=mapV.get(mer.getParent());
						v.setVersion_parent(vp);
						vp.getVersions().add(v);
						mapV.put(mer.getId(), v);
					}else {
						
					}
				}
			}
			for(PatchModuleRequest patch:mr.getBloc()) {
				if(patch.getId()!=null) {
					Version v=new Version();
					v.setId(patch.getId());
					Version vp=mapV.get(patch.getScene());
					v.setVersion_parent(vp);
					vp.getVersions().add(v);
				}else {
					Version v=new Version();
					v.setDescription(patch.getText());
					v.setVersion_level("Patch");
					String[] tab=patch.getTitle().split(" ");
					v.setNumero(Integer.parseInt(tab[0]));
					v.setTag(tab[1].substring(1, tab[1].length()-1));
					Version vp=mapV.get(patch.getScene());
					v.setVersion_parent(vp);
					vp.getVersions().add(v);
				}
				
			}
		}
		return mtl;
	}*/
}
