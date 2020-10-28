package com.rayen.plante;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.rayen.plante.entities.plante;
import com.rayen.plante.repos.PlanteRepository;
import com.rayen.plante.service.PlanteService;
@SpringBootTest
class PlanteApplicationTests {
@Autowired
private PlanteRepository planteRepository;
private PlanteService planteService ;
@Test
public void testCreatePlante() {
plante pl = new plante("TULIP","Move",32.500,new Date());
planteRepository.save(pl);
}

@Test
public void testFindPlante()
{
plante p = planteRepository.findById(1L).get();
System.out.println(p);
}
@Test
public void testUpdatePlante()
{
plante p = planteRepository.findById(1L).get();
p.setPrix(1000.0);
planteRepository.save(p);
}
@Test
public void testDeletePlante()

{
planteRepository.deleteById(1L);;
}

@Test
public void testListerTousPlantes()
{
List<plante> pl = planteRepository.findAll();
for (plante p : pl)
{
System.out.println(p);
}
}

@Test
public void testFindByNomPlanteContains()
{
Page<plante> pl =planteService.getAllPlantesParPage(0,2);
System.out.println(pl.getSize());
System.out.println(pl.getTotalElements());
System.out.println(pl.getTotalPages());
pl.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (plante p : pl)
{
System.out.println(p);
} */
}


}